package com.example.dtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class sen extends AppCompatActivity implements SensorEventListener{
    private TextView textView;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTemparatureSensoreAvaliable;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen);

        textView = findViewById(R.id.textviewb);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) !=null) {
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemparatureSensoreAvaliable = true;
        }else {
            textView.setText("tempurathure sensor is not avalible");
            isTemparatureSensoreAvaliable = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        textView.setText(sensorEvent.values[0]+" °C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if ( isTemparatureSensoreAvaliable){
            sensorManager.registerListener(this,tempSensor, SensorManager.SENSOR_DELAY_NORMAL);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isTemparatureSensoreAvaliable){
            sensorManager.unregisterListener(this);
        }
    }
}