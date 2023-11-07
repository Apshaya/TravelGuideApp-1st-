package com.example.dtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class contactus extends AppCompatActivity implements View.OnClickListener{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        Button contact = findViewById(R.id.More_Help);
        contact.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.More_Help:
                Toast.makeText(this,"contact us", Toast.LENGTH_LONG).show();
                Intent i = new Intent(contactus.this, help.class);
                startActivity(i);
                break;

        }

    }
}