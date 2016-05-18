package com.example.aoiumi.medecide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String RESULT_NUMBER = "ResultNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resultBtn = (Button) findViewById(R.id.main_result_btn);
        Button menuBtn =(Button) findViewById(R.id.main_menu_btn);

        resultBtn.setOnClickListener(this);
        menuBtn.setOnClickListener(this);

        Intent intent = new Intent(this, ResultActivity.class);

        Random random = new Random();
        int resultNumber = random.nextInt(10);

        intent.putExtra(RESULT_NUMBER, resultNumber);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.main_result_btn:

                if (ImageList.isEmptyImageList()) {

                    Toast.makeText(getApplicationContext(),
                            "CLOSETの中はからっぽです！", Toast.LENGTH_SHORT).show();

                } else {

                    Intent intentResult = new Intent(this, ResultActivity.class);

                    startActivity(intentResult);
                }
                break;

            case  R.id.main_menu_btn:

                Intent intentMenu = new Intent(this,MenuActivity.class);

                startActivity(intentMenu);
                break;
        }

    }
}
