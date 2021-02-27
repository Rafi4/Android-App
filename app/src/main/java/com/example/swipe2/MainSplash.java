package com.example.swipe2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainSplash extends AppCompatActivity {

    private static int SPALSH_SCREEN = 2500;

    ImageView imageView;
    TextView textView, textView2;
    Animation top, bottom, frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_splash);

        imageView = findViewById(R.id.lionImage);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);


        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);



        imageView.setAnimation(top);
        textView.setAnimation(bottom);
        textView2.setAnimation(bottom);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainSplash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPALSH_SCREEN);
    }
}

