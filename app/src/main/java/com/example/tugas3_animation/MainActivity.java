package com.example.tugas3_animation;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;




public class MainActivity extends AppCompatActivity {
    TextView tv1;
    ImageView im1,im2,im3;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    Animation testanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final KonfettiView konfettiView = findViewById(R.id.konfettiView);
        tv1 = (TextView) findViewById(R.id.tv1);
        bt1 = (Button) findViewById(R.id.buttonblink);
        bt2 = (Button) findViewById(R.id.buttonbounce);
        bt3 = (Button) findViewById(R.id.buttonmove);
        bt4 = (Button) findViewById(R.id.buttonzoomin);
        bt5 = (Button) findViewById(R.id.buttonrotate);
        bt6 = (Button) findViewById(R.id.buttonstop);
        bt7 = (Button) findViewById(R.id.buttonexplode);
        im1 = (ImageView) findViewById(R.id.im1);
        im2 = (ImageView) findViewById(R.id.im2);
        im3 = (ImageView) findViewById(R.id.im3);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
        final MediaPlayer mp2 = MediaPlayer.create(this,R.raw.sample2);
        Shape.DrawableShape drawableShape = new Shape.DrawableShape(AppCompatResources.getDrawable(this,R.drawable.ic_android),true);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt2.clearAnimation();
                bt1.clearAnimation();
                bt3.clearAnimation();
                bt4.clearAnimation();
                bt5.clearAnimation();
                bt6.clearAnimation();
                bt7.clearAnimation();
                im1.clearAnimation();
                mp.setLooping(false);
                tv1.setText("");
                im2.setImageResource(R.drawable.c);
                im2.setVisibility(View.VISIBLE);
                im1.setVisibility(View.GONE);
                testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                im2.startAnimation(testanim);


            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt2.clearAnimation();
                bt1.clearAnimation();
                bt3.clearAnimation();
                bt4.clearAnimation();
                bt5.clearAnimation();
                bt6.clearAnimation();
                bt7.clearAnimation();
                mp.start();
                tv1.setText("");
                im1.setImageResource(R.drawable.a);
                testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                im1.startAnimation(testanim);
                im2.clearAnimation();
                im1.setVisibility(View.VISIBLE);
                im2.setVisibility(View.GONE);
                mp.setLooping(true);
                mp.setVolume(0.2f,0.2f);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                im2.clearAnimation();
                im2.setVisibility(View.GONE);
                im1.setVisibility(View.GONE);
                im1.clearAnimation();
                tv1.clearAnimation();
                bt2.clearAnimation();
                bt1.clearAnimation();
                bt3.clearAnimation();
                bt4.clearAnimation();
                bt5.clearAnimation();
                bt6.clearAnimation();
                bt7.clearAnimation();
                tv1.setText("");
                mp.setLooping(false);
                startActivity(new Intent(getApplicationContext(),Nextpage.class));
                overridePendingTransition(R.anim.slideright,R.anim.slideleft);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.setLooping(false);
                tv1.setText("");
                im1.clearAnimation();
                im2.clearAnimation();
                im1.setVisibility(View.GONE);
                im2.setVisibility(View.GONE);
                testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                bt2.startAnimation(testanim);
                bt1.startAnimation(testanim);
                bt3.startAnimation(testanim);
                bt4.startAnimation(testanim);
                bt5.startAnimation(testanim);
                bt6.startAnimation(testanim);
                bt7.startAnimation(testanim);

            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt2.clearAnimation();
                bt1.clearAnimation();
                bt3.clearAnimation();
                bt4.clearAnimation();
                bt5.clearAnimation();
                bt6.clearAnimation();
                bt7.clearAnimation();
                mp.setLooping(false);
                tv1.setText("");
                im1.clearAnimation();
                im1.setImageResource(R.drawable.b);
                im1.setVisibility(View.VISIBLE);
                im2.clearAnimation();
                im2.setVisibility(View.GONE);
                testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                im1.startAnimation(testanim);

            }
        });



        bt6.setOnClickListener(v->{
            tv1.setText("");
            bt2.clearAnimation();
            bt1.clearAnimation();
            bt3.clearAnimation();
            bt4.clearAnimation();
            bt5.clearAnimation();
            bt6.clearAnimation();
            bt7.clearAnimation();
            mp.setLooping(false);
            im1.clearAnimation();
            im1.setVisibility(View.GONE);
            im2.clearAnimation();
            im2.setVisibility(View.GONE);
            mp2.start();
            testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce2);
            bt2.startAnimation(testanim);
            bt1.startAnimation(testanim);
            bt3.startAnimation(testanim);
            bt4.startAnimation(testanim);
            bt5.startAnimation(testanim);
            bt6.startAnimation(testanim);
            bt7.startAnimation(testanim);
            EmitterConfig emitterConfig = new Emitter(300, TimeUnit.MILLISECONDS).max(300);
            konfettiView.start(

                    new PartyFactory(emitterConfig)
                            .shapes(Shape.Circle.INSTANCE, Shape.Square.INSTANCE, drawableShape)
                            .spread(360)
                            .position(0.5,0.25,1,1)
                            .sizes(new Size(8,50,10))
                            .timeToLive(1500).fadeOutEnabled(true)
                            .build()
            );
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt2.clearAnimation();
                bt1.clearAnimation();
                bt3.clearAnimation();
                bt4.clearAnimation();
                bt5.clearAnimation();
                bt6.clearAnimation();
                bt7.clearAnimation();
                mp.setLooping(false);
                tv1.setText("Animation");
                im1.clearAnimation();
                im1.setVisibility(View.GONE);
                im2.clearAnimation();
                im2.setVisibility(View.GONE);
                testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                tv1.startAnimation(testanim);



            }
        });

    }


}