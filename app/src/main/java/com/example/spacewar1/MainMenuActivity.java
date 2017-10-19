package com.example.spacewar1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
//import android.support.v7.app.AppCompatActivity;


/**
 * Created by Макр on 29.03.2016.
 */

public class MainMenuActivity extends Activity{
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button = (ImageButton) findViewById(R.id.play);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainMenuActivity.this, LevelsActivity.class);
                startActivity(intent);
            }
        });
    }
}
