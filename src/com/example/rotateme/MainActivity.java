package com.example.rotateme;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	public int rotate; 
	public int i;
    private ImageView image;
   
   
    private float currentDegree = 0f;

   
    private SensorManager mSensorManager;

    TextView tvHeading;
    TextView tvHeading1;
    TextView tvHeading2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 
        image = (ImageView) findViewById(R.id.imageViewCompass);

        tvHeading = (TextView) findViewById(R.id.tvHeading);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        
    

    }

    @SuppressWarnings("deprecation")
	@Override
    protected void onResume() {
        super.onResume();

        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mSensorManager.unregisterListener(this);
    }
         
    @Override
    public void onSensorChanged(SensorEvent event) {
      
        float degree = Math.round(event.values[0]);  
        float deg1 =  Math.round(event.values[1]);
        float deg2 = Math.round(event.values[2]);
        
        tvHeading.setText(degree);
       
       int rot= i+1; 
 	   tvHeading.setText("Rotating at " + rot + " Me");
 	  
     
        RotateAnimation ra = new RotateAnimation(
                currentDegree, 
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f, 
                Animation.RELATIVE_TO_SELF,
                0.5f);

        ra.setDuration(210);

        ra.setFillAfter(true);

        image.startAnimation(ra);
        currentDegree = -degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
     
       {
    	 
    	   
       }
    }
}