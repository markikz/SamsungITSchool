package com.example.spacewar1;

/**
 * Created by Макр on 15.02.2016.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import java.util.Date;

public class GameField extends SurfaceView implements Runnable {
    static Resources res; //передаватьв левл


    Thread t;
    SurfaceHolder holder;

    boolean drawing;
    boolean moving;
    // boolean dragging;


    // Экран
    static float width, height;

    //Корабль
    Rect initialRectShip;
    Bitmap shipBitmap;
    PlayerShip shipPlayerSprite;
    int wShipPlayer, hShipPlayer;

    //астероид
    Rect initialRectAsteroid;
    Sprite asteroidSprite;
    Bitmap asteroidBitmap;
    int wAsteroid, hAsteroid;

    //armor
    Rect armorRect;
    Armor armorSprite;
    Bitmap armorBitmap;
    int wArmor, hArmor;

    //
    Rect initialRectBottomMenu;
    BottomMenu bottomMenu;
    Bitmap bottomMenuBitmap;
    int wBottomMenu, hBottomMenu;


    public GameField(Context context, float x, float y) {

        super(context);
        res = getResources();

        moving = true;

        holder = getHolder();

        height = y;
        width = x;

        //getWindowManager().getDefaultDisplay().getMetrics(metrics);


        shipBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ship_player);
        wShipPlayer = shipBitmap.getWidth() / 3;
        hShipPlayer = shipBitmap.getHeight();
        initialRectShip = new Rect(wShipPlayer * 2, 0, wShipPlayer * 3, hShipPlayer);
        shipPlayerSprite = new PlayerShip(width * 0.5, (height - hShipPlayer) - 150, 0, 0, initialRectShip, shipBitmap);
        shipPlayerSprite.addFrame(new Rect(wShipPlayer, 0, wShipPlayer * 2, hShipPlayer));
        shipPlayerSprite.addFrame(new Rect(0, 0, wShipPlayer, hShipPlayer));
        shipPlayerSprite.setFrameTime(50);


        asteroidBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.asteroid_medium_gray);
        wAsteroid = asteroidBitmap.getWidth() / 15;
        hAsteroid = asteroidBitmap.getHeight();
        initialRectAsteroid = new Rect(wAsteroid * 14, 0, wAsteroid * 15, hAsteroid);
        asteroidSprite = new Sprite(500, 200, 0, 0, initialRectAsteroid, asteroidBitmap);
        for (int i = 14; i > 0; i--) {
            asteroidSprite.addFrame(new Rect(wAsteroid * (i - 1), 0, wAsteroid * i, hAsteroid));
        }
        asteroidSprite.setFrameTime(100);


        armorBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shield32);
        wArmor = armorBitmap.getWidth();
        hArmor = armorBitmap.getHeight();
        armorRect = new Rect(0, 0, wArmor, hArmor);
        armorSprite = new Armor(width * 0.7, (height - hShipPlayer) - 150, 0, 0, armorRect, armorBitmap);
        //armorSprite.addFrame(new Rect(0, 0, wArmor, hArmor));
        //armorSprite.setFrameTime(100);

        bottomMenuBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_menu);
        wBottomMenu = bottomMenuBitmap.getWidth();
        hBottomMenu = bottomMenuBitmap.getHeight();
        initialRectBottomMenu = new Rect(0, 0, wBottomMenu, hBottomMenu);
        bottomMenu = new BottomMenu(width * 0.5 - wBottomMenu * 0.5, height - hBottomMenu - 30, 0, 0, initialRectBottomMenu, bottomMenuBitmap);


    }


    @Override
    public void run() {
        long before, now;

        before = new Date().getTime();
        while (drawing) {
            if (holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();

                now = new Date().getTime();
                update((int) (now - before));

                before = now;

                paint(canvas);


                holder.unlockCanvasAndPost(canvas);
            }
        }

    }


    private void update(int ms) {
        LevelsActivity.level.update(ms);
/*
        for (int i = 0; i < Level.mainList.size(); i++){
            Level.mainList.get(i).update(ms);
        }
        */

       /* if (shipPlayerSprite.getX() > width - shipPlayerSprite.getFrameWidth()) {
            shipPlayerSprite.setX((double) width - shipPlayerSprite.getFrameWidth());
        } else if (shipPlayerSprite.getX() < 0) {
            shipPlayerSprite.setX(0.0);
        }
        */

        //armorSprite.bonusUpdate(shipPlayerSprite.getX(), shipPlayerSprite.getY(), wShipPlayer, hShipPlayer);
        //shipPlayerSprite.updateBonusArmor(armorSprite.getX(), armorSprite.getY(), armorSprite.getFrameWidth(), armorSprite.getFrameHeight());

        //asteroidSprite.update(ms);
        //shipPlayerSprite.update(ms);

    }


    private void paint(Canvas canvas) {


        LevelsActivity.level.paint(canvas);
        //LevelsActivity.level.paint(canvas);


        /*
        for (int i = 0; i < Level.mainList.size(); i++){

            Level.mainList.get(i-1).draw(canvas);
        }
        */

        //Level.ex.draw(canvas);



        canvas.drawColor(Color.BLUE);
        shipPlayerSprite.draw(canvas);
        //asteroidSprite.draw(canvas);
        //armorSprite.draw(canvas);
        //bottomMenu.draw(canvas);
    }



    public void pause() {
        drawing = false;

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        drawing = true;
        t = new Thread(this);                                                                       //?
        t.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //bottomMenu.eventUpd(event);
       // shipPlayerSprite.motionUpdate(event);

        /*switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:


                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        */

        return true;
    }
}

