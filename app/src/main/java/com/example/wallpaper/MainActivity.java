package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int next = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
    }

    public void changewallpaper(View v) {
        setwallPaper();
    }

    public void setwallPaper() {
        Button button = (Button)findViewById(R.id.b1);
        button.setText("Click Me !");
        mytimer.schedule(new TimerTask() {
                             @Override
                             public void run() {
                                 if (next == 1) {
                                     drawable = getResources().getDrawable(R.drawable.a);
                                     next = 2;
                                 } else if (next == 2) {
                                     drawable = getResources().getDrawable(R.drawable.b);
                                     next = 3;
                                 } else if (next == 3) {
                                     drawable = getResources().getDrawable(R.drawable.c);
                                     next = 4;
                                 } else if (next == 4) {
                                     drawable = getResources().getDrawable(R.drawable.d);
                                     next = 5;
                                 } else if (next == 5) {
                                     drawable = getResources().getDrawable(R.drawable.e);
                                     next = 6;
                                 } else if (next == 6) {
                                     drawable = getResources().getDrawable(R.drawable.f);
                                     next = 7;
                                 } else if (next == 7) {
                                     drawable = getResources().getDrawable(R.drawable.g);
                                     next = 1;
                                 }
                                 Bitmap img = ((BitmapDrawable) drawable).getBitmap();
                                 try {
                                     wpm.setBitmap(img);
                                 }
                                 catch (IOException e) {
                                     e.printStackTrace();
                                 }
                             }
                         },3000,5000
                );
    }

}

