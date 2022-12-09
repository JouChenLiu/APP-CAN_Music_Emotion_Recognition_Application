package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Calendar;

public class SplashScreen extends AppCompatActivity {

    TextView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        super.onCreate(savedInstanceState);

        if(timeOfDay >= 8 && timeOfDay < 16){

            //day
            setContentView(R.layout.activity_splash_screen);

        }else if(timeOfDay >= 16 && timeOfDay < 20){

            //afternoon
            setContentView(R.layout.splash_screen_1);

        }else if(timeOfDay >= 20 && timeOfDay < 24){

            //night
            setContentView(R.layout.splash_screen_2);

        }else if(timeOfDay>=0 && timeOfDay<4){

            //night
            setContentView(R.layout.splash_screen_3);

        }

        else if(timeOfDay >= 4 && timeOfDay < 8){

            //dawn
            setContentView(R.layout.splash_screen_4);

        }

        appname = findViewById(R.id.appname);
        lottie = findViewById(R.id.lottie);

        appname.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(3500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), comfort.class);
                startActivity(i);
            }
        }, 5000);


    }
}