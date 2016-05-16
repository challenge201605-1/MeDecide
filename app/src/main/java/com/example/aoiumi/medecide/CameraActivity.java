package com.example.aoiumi.medecide;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class CameraActivity extends Activity implements View.OnClickListener {

    SurfaceView sv;
    SurfaceHolder sh;
    Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // FrameLayout(親ビュー)を新規作成
        FrameLayout fl = new FrameLayout(this);
        setContentView(fl);

        // カメラ表示用のビューを定義
        sv = new SurfaceView(this);
        sh = sv.getHolder();
        sh.addCallback(new SurfaceHolderCallback());

        // 撮影ボタンを定義
        Button captureBtn = new Button(this);
        captureBtn.setText("撮影");
        captureBtn.setLayoutParams(new LayoutParams(200, 150));
        captureBtn.setOnClickListener(new TakePictureClickListener());

        // 戻るボタンを定義
        Button backBtn = new Button(this);
        backBtn.setText("戻る");
        backBtn.setLayoutParams(new LayoutParams(200, 150));
        backBtn.setOnClickListener(this);


        // ボタン配置用のLinearLayoutを定義
        LinearLayout btnLayout = new LinearLayout(this);
        btnLayout.setOrientation(LinearLayout.VERTICAL);
        btnLayout.addView(captureBtn);
        btnLayout.addView(backBtn);

        // 親ビューに追加
        fl.addView(sv);
        fl.addView(btnLayout);
    }

    @Override
    public void onClick(View view) {
        // 戻るボタンの処理をここに書く
        switch (view.getId()) {

            case R.id.camera_back_btn:

                Intent intentMenu = new Intent(this,MenuActivity.class);

                startActivity(intentMenu);
                break;
        }
    }


    class SurfaceHolderCallback implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            cam = Camera.open();
            Parameters param = cam.getParameters();
            List<Size> ss = param.getSupportedPictureSizes();
            Size pictSize = ss.get(0);

            param.setPictureSize(pictSize.width, pictSize.height);
            cam.setParameters(param);
        }
        @Override
        public void surfaceChanged(SurfaceHolder holder, int f, int w, int h) {
            try {
                cam.setDisplayOrientation(0);
                cam.setPreviewDisplay(sv.getHolder());

                Parameters param = cam.getParameters();
                List<Size> previewSizes =
                        cam.getParameters().getSupportedPreviewSizes();
                Size pre = previewSizes.get(0);
                param.setPreviewSize(pre.width, pre.height);

                LayoutParams lp = new LayoutParams(pre.width, pre.height);
                sv.setLayoutParams(lp);

                cam.setParameters(param);
                cam.startPreview();
            } catch (Exception e) { }
        }
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            cam.stopPreview();
            cam.release();
        }
    }
    class TakePictureClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            cam.takePicture(new Camera.ShutterCallback() {
                @Override
                public void onShutter() {}
            }, null, new TakePictureCallback());
        }
    }

    class TakePictureCallback implements Camera.PictureCallback {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                ImageList imageList= new ImageList(data);
                imageList.save();


                Toast.makeText(getApplicationContext(),
                        "写真を保存しました", Toast.LENGTH_LONG).show();
                cam.startPreview();
            } catch (Exception e) { }
        }
    }
}