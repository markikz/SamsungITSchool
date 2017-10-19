package com.example.spacewar1;

import android.graphics.Canvas;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Макр on 27.03.2016.
 */

public class Level {
    private ArrayList<Long> timing;
    private ArrayList<Sprite> enemies;
    private ArrayList<Sprite> mainList = new ArrayList<Sprite>();
    static Sprite ex;
    private int i = 0;


    Timer timer;
    TimerTask task;


    public Level(ArrayList<Long> timing, ArrayList<Sprite> enemies) {
        ex = enemies.get(1);



        this.timing = timing;
        this.enemies = enemies;

        timer = new Timer();
        task = new MyTimerTask();

        timer.schedule(task, 1000);
    }

    public void paint(Canvas canvas) {


        ex.draw(canvas);

        for (int i = 0; i <= mainList.size(); i++) {


            enemies.get(1).draw(canvas);
            //if(mainList.size()>i)
            //mainList.get(i).draw(canvas);

        }

    }

    public void update(int ms) {
       // enemies.get(1).update(ms);

    }


    class MyTimerTask extends TimerTask {
        @Override
        public void run() {

            if (i < enemies.size()) {
                Log.i(MainActivity.tag, timing.get(i).toString());

                mainList.add(enemies.get(i));

                //ex = enemies.get(i);

                timer.cancel();
                task.cancel();

                timer = new Timer();
                task = new MyTimerTask();

                i += 1;
            } else {
                Log.i(MainActivity.tag, "timer canceled");
                task.cancel();
                timer.cancel();
            }
        }
    }
}
