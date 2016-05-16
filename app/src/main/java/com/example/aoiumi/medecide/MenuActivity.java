package com.example.aoiumi.medecide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton cameraBtn = (ImageButton) findViewById(R.id.menu_camera);

        cameraBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.menu_camera:
                Intent intentCamera = new Intent(this,CameraActivity.class);

                startActivity(intentCamera);
                break;
        }

    }
}