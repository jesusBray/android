package com.example.app_fisica2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView tren;
    private Button startButton;
    private Button resetbutton;

    //statics variables T, D
    private final long TIEMPO= 2000;
    private final long DISTANCIA= 500;

    private EditText distancia;
    private EditText tiempo;
    private TextView resultVel;
    private String showResult;
    private ObjectAnimator objectAnimator;
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting image of view
        tren = findViewById(R.id.tren);
        this.startButton = findViewById(R.id.button);

        //configuration of STARTBUTON
        startButton = findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animacion("startObjet");
            }
        });

        //configuration of RESETBUTTON
        resetbutton = findViewById(R.id.resetbutton);
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animacion("resetObjet");
            }
        });


        distancia = findViewById(R.id.distancia);
        tiempo = findViewById(R.id.tiempo);
        resultVel = findViewById(R.id.velocidad);

    }

    public void Animacion(final String animacion) {

        long t = Wrapper.getParseEditText(this.tiempo);
        long d = Wrapper.getParseEditText(this.distancia);

        switch (animacion) {
            case "startObjet":
                //call method velodicity
                this.showResult = Wrapper.getWrapString(Velocity.getVelocidy(d,t));
                this.resultVel.setText(showResult);
                //config axis and distance
                objectAnimator = Animation.setValues(tren, "x", d);
                //config time
                objectAnimator.setDuration(t*1000);
                //start animation
                new Animation(objectAnimator).StartAnimation();
                break;
            case "resetObjet":
                //this method reallocate values
                objectAnimator.setRepeatMode(objectAnimator.RESTART);
                //config axis and distance
                objectAnimator = Animation.setValues(tren, "x", 0);
                //start animation
                new Animation(objectAnimator).StartAnimation();
                break;
            default:
                Toast.makeText(this,"valores no asignados", Toast.LENGTH_SHORT);
                break;
        }
    }

    public void NextActivity2(View view) {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

}
