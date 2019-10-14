package com.example.app_fisica2;

public class Acceleration {
    public static double getAcceleration(double v0, double vf, double time){
        return (vf-v0)*time;
    }
}
