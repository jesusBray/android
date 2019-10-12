package com.example.app_fisica2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

public class Animation {

    public static void setStartAnimation(ObjectAnimator objectAnimator){
        AnimatorSet a = new AnimatorSet();
        a.play(objectAnimator);
        a.start();
    }
}
