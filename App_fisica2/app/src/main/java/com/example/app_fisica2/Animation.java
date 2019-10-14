package com.example.app_fisica2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

public class Animation {

    private ObjectAnimator objectAnimator;
    public Animation(ObjectAnimator objectAnimator){
        this.objectAnimator = objectAnimator;

    }

    public static void setStartAnimation(ObjectAnimator objectAnimator){
        AnimatorSet a = new AnimatorSet();
        a.play(objectAnimator);
        a.start();
    }

    public void StartAnimation(String option) {
        switch (option) {
            case "startObjet":

                break;
            case "resetObjet":

                break;
                default:
                    break;


        }
    }


}
