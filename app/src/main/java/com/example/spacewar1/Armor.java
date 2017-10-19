package com.example.spacewar1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by Макр on 01.04.2016.
 */
public class Armor extends Sprite{

    public Armor(double x, double y, double velocityX, double velocityY, Rect initialFrame, Bitmap bitmap) {
        super(x, y, velocityX, velocityY, initialFrame, bitmap);
    }


    public void bonusUpdate(double xShip, double yShip, int wShipPlayer, int hShipPlayer){
       // if ((getX() + getFrameWidth() >= xShip && getX()<=xShip + wShipPlayer) && (getY() + getFrameHeight() >= yShip && getY() <= yShip + hShipPlayer)){

       // }
    }
}
