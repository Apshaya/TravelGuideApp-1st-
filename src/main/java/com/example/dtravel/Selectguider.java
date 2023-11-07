package com.example.dtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class Selectguider extends AppCompatActivity implements View.OnClickListener{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectguider);


        Button guidone = findViewById(R.id.guiderone3);


        Button letestdet = findViewById(R.id.letestguiders);


        guidone.setOnClickListener(this);

        letestdet.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.guiderone3:
                Toast.makeText(this,"Guiders profiles", Toast.LENGTH_LONG).show();
                Intent profile = new Intent(Selectguider.this, guiderprofilesaman.class);
                startActivity(profile);
                break;

            case R.id.letestguiders:
                Toast.makeText(this,"Get Your latest Guider", Toast.LENGTH_LONG).show();
                Intent adddetail = new Intent(Selectguider.this, adddetails.class);
                startActivity(adddetail);
                break;

        }

    }
}