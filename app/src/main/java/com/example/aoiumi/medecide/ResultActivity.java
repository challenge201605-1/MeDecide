package com.example.aoiumi.medecide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button ResultBackBtn = (Button) findViewById(R.id.result_back_btn);

        ResultBackBtn.setOnClickListener(this);
    }


        @Override
        public void onClick(View view) {

            switch (view.getId()) {

            case R.id.result_back_btn:
                Intent intentMain = new Intent(this,MainActivity.class);

                startActivity(intentMain);
                break;

        }



    }
}
