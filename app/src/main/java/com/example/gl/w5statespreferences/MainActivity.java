package com.example.gl.w5statespreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.jsoup.nodes.Element;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private int counter=0;
    private MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("IBR", "onCreate is called.");
        //music = MediaPlayer.create(this,R.raw.nyan);
        //music.start();

        sharedPreferences = this.getSharedPreferences("counterFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    protected void onStart() {
        super.onStart(); // you need always call this function.
        Log.i("IBR", "onStart is called");
        counter = sharedPreferences.getInt("count", 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("IBR", "onResume is called");
        //music.start();



    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("IBR", "onPause is called");
        //music.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("IBR", "onStop is called");
        editor.putInt("count", counter);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("IBR", "onDestroy is called");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("IBR", "onRestart is called");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("counter", counter);
        Log.i("IBR", "onSaveInstance is called");
    }

    public void increment(View view) {
        counter++;
        Toast.makeText(this,"Counter :" + counter, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        counter = bundle.getInt("counter");
        Log.i("IBR", "onRestoreInstance is called");
    }

    public void switchActivity(View view) {
        Intent intent = new Intent(this,AnotherActivity.class);
        startActivity(intent);

    }
}
