package com.example.app_fisica2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

public class Animation {

    private ObjectAnimator objectAnimator;
    private AnimatorSet a;

    public Animation(ObjectAnimator objectAnimator) {
        this.objectAnimator = objectAnimator;
        a = new AnimatorSet();
    }

    public void StartAnimation() {
        this.a.play(this.objectAnimator);
        this.a.start();
    }

    public static ObjectAnimator setValues(ImageView image, String axis, long distanse){
        return ObjectAnimator.ofFloat(image, axis, distanse);
    }


}
