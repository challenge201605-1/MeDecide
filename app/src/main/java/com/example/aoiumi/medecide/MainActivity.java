package com.example.aoiumi.medecide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resultBtn = (Button) findViewById(R.id.main_result_btn);
        Button menuBtn =(Button) findViewById(R.id.main_menu_btn);

        resultBtn.setOnClickListener(this);
        menuBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.main_result_btn:

                Intent intentResult = new Intent(this,ResultActivity.class);

                startActivity(intentResult);
                break;

            case  R.id.main_menu_btn:

                Intent intentMenu = new Intent(this,MenuActivity.class);

                startActivity(intentMenu);
                break;
        }

    }
}
