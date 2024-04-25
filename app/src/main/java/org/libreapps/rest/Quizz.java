package org.libreapps.rest;

import androidx.annotation.NonNull;

import org.json.JSONObject;

public class Quizz {
    int id, nbPoint;
    String question, choixA, choixB, choixC, choixD, reponse;

    public Quizz(JSONObject jObject) {
        this.id =jObject.optInt("id");
        this.question = jObject.optString("question");
        this.choixA = jObject.optString("choixA");
        this.choixB = jObject.optString("choixB");
        this.choixC = jObject.optString("choixC");
        this.choixD = jObject.optString("choixD");
        this.reponse = jObject.optString("reponse");
        this.nbPoint = jObject.optInt("nbPoint");
    }

    public int getId() {return id;}
    public int getNbPoint() {return nbPoint;}
    public String getQuestion() {
        return question;
    }
    public String getChoixA() {
        return choixA;
    }



    public void setId(int id) {this.id = id;}
    public void setNbPoint(int nbPoint) {this.nbPoint = nbPoint;}
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setChoixA(String choixA) {
        this.choixA = choixA;
    }

    public String getChoixB() {
        return choixB;
    }

    public void setChoixB(String choixB) {
        this.choixB = choixB;
    }

    public String getChoixC() {
        return choixC;
    }

    public void setChoixC(String choixC) {
        this.choixC = choixC;
    }

    public String getChoixD() {
        return choixD;
    }

    public void setChoixD(String choixD) {
        this.choixD = choixD;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @NonNull
    @Override
    public String toString() {
        return "Quizz="+this.getId()+" "+this.getQuestion();
    }
}
