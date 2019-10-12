package com.example.app_fisica2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView tren;
    private Button startButton;
    private Button resetbutton;
    private final long TIEMPO= 2000;
    private final long DISTANCIA= 500;

    private EditText distancia;
    private EditText tiempo;
    private TextView resultVel;

    private ObjectAnimator objectAnimator;

    //
    private ObjectAnimator objectAnimatorY;
    //

    private AnimatorSet animatorSet;
    AnimatorSet animatorSetX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting image of view
        tren = (ImageView)findViewById(R.id.tren);
        this.startButton = (Button)findViewById(R.id.button);

        //configuration of STARTBUTON
        startButton = (Button)findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("startObjet");
            }
        });

        //configuration of RESETBUTTON
        resetbutton = (Button) findViewById(R.id.resetbutton);
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("resetObjet");
            }
        });

        distancia = (EditText)findViewById(R.id.distancia);
        tiempo = (EditText)findViewById(R.id.tiempo);
        resultVel = (TextView)findViewById(R.id.velocidad);

    }

    public void animacion(final String animacion) {
        long t = Long.parseLong(tiempo.getText().toString());
        long d = Long.parseLong(distancia.getText().toString());
        long resultTime = t*1000;
        switch (animacion) {
            case "startObjet":
                //asingt operation
                Velocidad(d,t);

                objectAnimator = ObjectAnimator.ofFloat(tren, "x", d);
                objectAnimator.setDuration(resultTime);
                animatorSet = new AnimatorSet();
                animatorSet.play(objectAnimator);
                animatorSet.start();
                break;

            case "stopObjet":

//                objectAnimator = ObjectAnimator.ofFloat(tren, "x", 0f);
//                objectAnimator.setAutoCancel(stopVAlue);
//                AnimatorSet animatorStop = new AnimatorSet();
//                animatorStop.play(objectAnimator);
//                animatorStop.end();
//                final AnimatorSet animatorSet = new AnimatorSet();
                //animatorSet.pause();

                objectAnimator.setupEndValues();
                animatorSet.removeAllListeners();
                animatorSet.end();
                animatorSet.cancel();

                break;

            case "resetObjet":
                //asingt operation
                Velocidad(d,t);
//                objectAnimator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                        super.onAnimationCancel(animation);
//                        tren.setScaleX(0);
//                    }
//                });
//                objectAnimator.setRepeatMode(ObjectAnimator.ofFloat(tren,"x", 44f));
//                objectAnimator = ObjectAnimator.ofFloat(tren, "x",0,0f);

                Path path = new Path();
                path.moveTo(0, -3);

                objectAnimator.setRepeatMode(objectAnimator.REVERSE);
//                objectAnimator = ObjectAnimator.ofFloat(tren, "x", "y", path);
//                objectAnimator.setRepeatMode(objectAnimator.start());

                objectAnimator = ObjectAnimator.ofFloat(tren, "x", 0f);
//                objectAnimatorY = ObjectAnimator.ofFloat(tren, "y", 0f);

//                objectAnimator = ObjectAnimator.ofFloat(tren, "x", 250f);
//                animatorSet.playTogether(ObjectAnimator.ofFloat(objectAnimator,"x",12f));
//                objectAnimator.setDuration(10000);
                animatorSetX = new AnimatorSet();
                animatorSetX.play(objectAnimator);
                animatorSetX.start();
                break;
            default:
                break;
        }
    }

    public void Velocidad(double dist, double tim) {
        double result = dist/tim;
        String v1 = String.valueOf(result);
        this.resultVel.setText(v1);
    }

}
