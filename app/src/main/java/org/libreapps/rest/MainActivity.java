package org.libreapps.rest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Param.getInstance().setListQizz(getListData());

        /*
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, listData));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Product upload = (Product) o;
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("id", upload.getId());
                intent.putExtra("name", upload.getName());
                intent.putExtra("type", upload.getType());
                intent.putExtra("price", upload.getPrice());
                startActivity(intent);
            }
        });
         */

    }

    public ArrayList<Quizz> getListData(){
        try{
            ConnectionRest connectionRest = new ConnectionRest();
           // connectionRest.setAction("quizz");
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            if(listJsonObjs != null) {
                return parseQuizz(listJsonObjs);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Quizz> parseQuizz(final String json) {
        try {
            final ArrayList<Quizz> quizzes = new ArrayList<>();
            final JSONArray jProductArray = new JSONArray(json);
            for (int i = 0; i < jProductArray.length(); i++) {
                quizzes.add(new Quizz(jProductArray.optJSONObject(i)));
                //Log.v("Quizz", quizzes.toString());//TODO
            }
            return quizzes;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }
}