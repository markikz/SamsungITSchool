package com.example.spacewar1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.util.DisplayMetrics;
import android.util.Log;



public class MainActivity extends Activity {

    GameField game;
    DisplayMetrics metrics;

    static final String tag = "GAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //разрешение экрана
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        super.onCreate(savedInstanceState);
        game = new GameField(this,metrics.widthPixels, metrics.heightPixels);
        
        setContentView(game);
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.pause();
    }

    @Override
    protected void onResume() {

        super.onResume();
        game.resume();
        Log.i(tag, "onResume");
    }
}