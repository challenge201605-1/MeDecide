package com.example.aoiumi.medecide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button ResultBackBtn = (Button) findViewById(R.id.result_back_btn);
        ResultBackBtn.setOnClickListener(this);

        ImageView closet = (ImageView) findViewById(R.id.imagefuku);
        List<ImageList> imageLists = ImageList.listAll(ImageList.class);

        int num = new java.util.Random().nextInt(imageLists.size());
        Bitmap bmp = null;
        byte[] bytes = imageLists.get(num).image_data;
        if (bytes != null) {
            bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }

        closet.setImageBitmap(bmp);
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