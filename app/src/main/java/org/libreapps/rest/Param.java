package org.libreapps.rest;

import java.util.ArrayList;

public class Param {
    private String token;
    private static Param param;
    private ArrayList<Quizz> listQizz;

    private Param() {
    }

    public static Param getInstance() {
        if (param == null) {
            param = new Param();
        }
        return param;
    }

    public String getToken() { return token; }
    public ArrayList<Quizz> getListQizz() {return listQizz;}

    public void setToken(String token) { this.token = token; }
    public void setListQizz(ArrayList<Quizz> listQizz) {this.listQizz = listQizz;}
}