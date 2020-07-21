package com.example.profileapplication;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class Welcome extends AppCompatActivity {
Thread timer;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView=findViewById(R.id.imageView1);
        Glide.with(this).load(R.drawable.first).into(imageView);
        timer=new Thread()
        {
            public void run()
            {
                try {
                    sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally{


                    Intent i=new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                }
            }

        };
        timer.start();
    }
}

