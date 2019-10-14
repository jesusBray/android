package com.example.app_fisica2;

import android.widget.EditText;

public class Wrapper {

    public static long parseCad(String a){
        return Long.parseLong(a);
    }

    public static double vel(double d, double t){
        return d/t;
    }

    public static String getWrapString(double resultV){
        return String.valueOf(resultV);
    }

    public static long getParseEditText(EditText value){
        return Long.parseLong(value.getText().toString());
    }
}
