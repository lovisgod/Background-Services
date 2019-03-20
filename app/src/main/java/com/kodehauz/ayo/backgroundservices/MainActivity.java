package com.kodehauz.ayo.backgroundservices;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_query);

        input = editText.getText().toString();
    }

    public void startService(View view) {
       //here we send an intent to the service class to start the service
        Intent serviceIntent = new Intent(this, ExampleService.class);
        serviceIntent.putExtra("Intent", input);
        //we use startService for services instead of startactivity for starting activities
        // we can also use start foreground services to start the service when the activity is not up
        //the ContextCompat is use to check if the device is running on a particular api
        //so it uses statForeground  services else it use startService
        ContextCompat.startForegroundService(this, serviceIntent);

    }

    public void stopService(View view) {
    //here we send an intent to the service class to stop the service
        Intent serviceIntent = new Intent(this, ExampleService.class);
        stopService(serviceIntent);

    }
}
