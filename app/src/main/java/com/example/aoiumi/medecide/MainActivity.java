package com.example.aoiumi.medecide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageList imageList= new ImageList(new byte[]{00101});
        imageList.save();

        List<ImageList> imageLists = ImageList.listAll(ImageList.class);
        for (ImageList data : imageLists) {
            Log.d("test", data.toString());
        }
    }
}
