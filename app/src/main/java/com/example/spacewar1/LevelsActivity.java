package com.example.spacewar1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Макр on 09.04.2016.
 */
public class LevelsActivity extends Activity {

    static Level level;


    ImageButton level1;
    Intent intent;

    Bitmap bitmapShipPlayer;
    Bitmap bitmapArmor;
    Bitmap bitmapComet;
    Bitmap bitmapAsteroid;

    Rect rectArmor;

    Armor spriteArmor;

    DisplayMetrics metrics;
    float width, height;

    int wShipPlayer, hShipPlayer;
    int wArmor, hArmor;
    int wComet, hComet;
    int wAsteroid, hAsteroid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels;
        width = metrics.widthPixels;

        level1 = (ImageButton) findViewById(R.id.level1);

        bitmapShipPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.ship_player);
        wShipPlayer = bitmapShipPlayer.getWidth() / 3;
        hShipPlayer = bitmapShipPlayer.getHeight();

        bitmapArmor = BitmapFactory.decodeResource(getResources(), R.drawable.shield32);
        wArmor = bitmapArmor.getWidth();
        hArmor = bitmapArmor.getHeight();
        rectArmor = new Rect(0, 0, wArmor, hArmor);
        spriteArmor = new Armor(width*0.5, height*0.2, 0, 0, rectArmor, bitmapArmor);
        //spriteArmor =  new Armor(width * 0.7, (height - hShipPlayer) - 150, 0, 0, rectArmor,
        //        bitmapArmor);

        bitmapArmor = BitmapFactory.decodeResource(getResources(), R.drawable.shield32);
        wArmor = bitmapArmor.getWidth();
        hArmor = bitmapArmor.getHeight();
        Rect rectArmor1 = new Rect(0, 0, wArmor, hArmor);
        Armor spriteArmor1 = new Armor(width*0.7, height*0.1, 1, 0, rectArmor, bitmapArmor);




        bitmapComet = BitmapFactory.decodeResource(getResources(), R.drawable.comet32);
        wComet = bitmapComet.getWidth();
        hComet = bitmapComet.getHeight();

        bitmapAsteroid = BitmapFactory.decodeResource(getResources(), R.drawable.asteroid_medium_gray);
        wAsteroid = bitmapAsteroid.getWidth();
        hAsteroid = bitmapAsteroid.getHeight();

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Sprite> enemies = new ArrayList<Sprite>();
                enemies.add(spriteArmor);
                enemies.add(spriteArmor);
                enemies.add(spriteArmor);

                ArrayList<Long> timing = new ArrayList<Long>();
                timing.add((long) 10000);
                timing.add((long) 100);
                timing.add((long) 20000);

                level = new Level(timing, enemies);
                intent = new Intent(LevelsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
