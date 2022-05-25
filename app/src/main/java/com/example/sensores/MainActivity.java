package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    Sensor accelerometer;
    SensorManager sensorManager;
    float sensorX;
    float sensorY;
    float sensorZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = (sensorManager).getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        sensorX = sensorEvent.values[0];
        sensorY = sensorEvent.values[1];
        sensorZ = sensorEvent.values[2];
        TextView tx = (TextView) findViewById(R.id.tX);
        TextView ty = (TextView) findViewById(R.id.tY);
        TextView tz = (TextView) findViewById(R.id.tZ);
        tx.setText("X: "+(sensorX));
        ty.setText("Y: "+(sensorY));
        tz.setText("Z: "+(sensorZ));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}