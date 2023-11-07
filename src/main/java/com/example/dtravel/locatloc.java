package com.example.dtravel;

import static com.example.dtravel.R.id.Source;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class locatloc extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locatloc);

        Button yourloc = findViewById(R.id.yourloc);
        yourloc.setOnClickListener(this);


        EditText editTextSource = findViewById(R.id.Source);
        EditText editTextDestination = findViewById(R.id.destination);
        Button button = findViewById(R.id.btnSubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String source = editTextSource.getText().toString();
                String destination = editTextDestination.getText().toString();
                if (source.equals("") && destination.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter both and destination",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source + "/" + destination);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yourloc:
                Toast.makeText(this, "your Location", Toast.LENGTH_LONG).show();
                Intent profile = new Intent(locatloc.this, MapsActivity.class);
                startActivity(profile);
                break;


        }
    }}