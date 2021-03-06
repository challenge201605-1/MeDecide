package com.example.aoiumi.medecide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton cameraBtn = (ImageButton) findViewById(R.id.menu_camera);

        cameraBtn.setOnClickListener(this);

        Button clearBtn = (Button) findViewById(R.id.menu_clear_btn);
        clearBtn.setOnClickListener(this);

        Button MainBackBtn = (Button) findViewById(R.id.menu_back_btn);

        MainBackBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.menu_camera:
                Intent intentCamera = new Intent(this,CameraActivity.class);

                startActivity(intentCamera);
                break;

            case  R.id.menu_clear_btn:
                ImageList.deleteAll(ImageList.class);
                Toast.makeText(getApplicationContext(),
                        "CLOSETの中身を全て削除しました！", Toast.LENGTH_SHORT).show();

                break;

            case R.id.menu_back_btn:
                Intent intentMain = new Intent(this,MainActivity.class);

                startActivity(intentMain);
                break;
        }

    }
}