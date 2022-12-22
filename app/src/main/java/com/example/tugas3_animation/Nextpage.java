package com.example.tugas3_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Nextpage extends AppCompatActivity {
    Animation testanim;
    ImageView im3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);
        im3 = (ImageView) findViewById(R.id.im3);
        b1 = (Button) findViewById(R.id.button1);

        testanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
        im3.startAnimation(testanim);
        im3.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Boo!", Toast.LENGTH_SHORT).show();





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                im3.clearAnimation();
                im3.setVisibility(View.GONE);
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slidetoright,R.anim.slidetoleft);
    }
}