package com.example.app_fisica2;

public class Acceleration {
    public static double getAcceleration(double v0, double vf, double time){
        return (vf-v0)*time;
    }

    public static double getDistanceWithAcce(double v0, double vf, double time){
        double v= (vf+v0)/2;
        return v*time;
    }

    public static double getTimeWithAcce(double v0, double vf, double acceleration){
        return (vf-v0)/ acceleration;
    }
}
