package com.example.dtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class homwActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homw);

        VideoView videoView = findViewById(R.id.videoView2);
        videoView.setVideoPath("android.resource://"+ getPackageName() + "/" + R.raw.dire);
        videoView.start();

        Button sensors = findViewById(R.id.sensorss);
        Button chooseplace = findViewById(R.id.Chooseyourplace);
        Button guider = findViewById(R.id.Guider);
        Button traveler = findViewById(R.id.Traveler);
        Button populerplace = findViewById(R.id.populerplace);
        Button aboutus = findViewById(R.id.aboutus);
        Button contactus = findViewById(R.id.countactus);

        sensors.setOnClickListener(this);
        chooseplace.setOnClickListener(this);
        guider.setOnClickListener(this);
        traveler.setOnClickListener(this);
        populerplace.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        contactus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sensorss:
                Toast.makeText(this,"sensor", Toast.LENGTH_LONG).show();
                Intent i = new Intent(homwActivity.this, sen.class);
                startActivity(i);
                break;

            case R.id.Chooseyourplace:
                Toast.makeText(this,"Map", Toast.LENGTH_LONG).show();
                Intent o = new Intent(homwActivity.this, locatloc.class);
                startActivity(o);
                break;

            case R.id.Guider:
                Toast.makeText(this,"add details", Toast.LENGTH_LONG).show();
                Intent p = new Intent(homwActivity.this, adddetails.class);
                startActivity(p);
                break;

            case R.id.aboutus:
                Toast.makeText(this,"about us", Toast.LENGTH_LONG).show();
                Intent q = new Intent(homwActivity.this, Aboutus.class);
                startActivity(q);
                break;

            case R.id.countactus:
                Toast.makeText(this,"contact us", Toast.LENGTH_LONG).show();
                Intent r = new Intent(homwActivity.this, contactus.class);
                startActivity(r);
                break;

            case R.id.populerplace:
                Toast.makeText(this,"populer place", Toast.LENGTH_LONG).show();
                Intent s = new Intent(homwActivity.this, populerActivity.class);
                startActivity(s);
                break;

            case R.id.Traveler:
                Toast.makeText(this,"Select guider", Toast.LENGTH_LONG).show();
                Intent t = new Intent(homwActivity.this, Selectguider .class);
                startActivity(t);
                break;
        }

    }
}