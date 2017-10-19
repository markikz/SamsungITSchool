package com.example.spacewar1;

import android.content.res.Resources;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Макр on 28.03.2016.
 */

public class PlayerShip extends Sprite {

    //
    private int widthShip;
    private int heightShip;


    //перемещение
    private double shipX;
    private double eventX;
    private double difX;


    public PlayerShip(double x, double y, double velocityX, double velocityY, Rect initialFrame, Bitmap bitmap) {
        super(x, y, velocityX, velocityY, initialFrame, bitmap);

        widthShip = initialFrame.width();
        heightShip = initialFrame.height();
    }

    public int getWidthShip() {
        return widthShip;
    }

    public int getHeightShip() {
        return heightShip;
    }

    public void setHeightShip(int heightShip) {
        this.heightShip = heightShip;
    }

    public void setWidthShip(int widthShip) {
        this.widthShip = widthShip;
    }

    public void motionUpdate(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                shipX = getX();
                eventX = event.getX();

                difX = eventX - shipX;

                break;
            case MotionEvent.ACTION_MOVE:
                if (getX() <= event.getX() && getX() + getInitialFrame().width() >= event.getX()) {
                    shipX = getX();
                    eventX = event.getX();
                    setX(eventX - difX);
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
    }

    public void updateBonusArmor(double x, double y, int width, int height){
        if ((getX() + getFrameWidth() >= x && getX()<=x + width) && (getY() + getFrameHeight() >= y && getY() <= y + height)){
            //Bitmap b = BitmapFactory.decodeResource(GameField.res, R.drawable.armorSprite);

           // setBitmap(b);

           // int newW = b.getWidth() / 3;
           // int newH = b.getHeight();
          //  Rect newR = new Rect(newW * 2, 0, newH * 3, newH);
           // setInitialFrame(newR);
            //shipPlayerSprite.addFrame(new Rect(wShipPlayer, 0, wShipPlayer * 2, hShipPlayer));
            //shipPlayerSprite.addFrame(new Rect(0, 0, wShipPlayer, hShipPlayer));

        }
    }
}
