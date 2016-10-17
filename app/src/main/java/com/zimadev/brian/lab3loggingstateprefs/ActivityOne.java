package com.zimadev.brian.lab3loggingstateprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

    // string for logcat documentation
    private final static String TAG = "Lab-ActivityOne";


    // lifecycle counts
    int onCreateCtr;
    int onStartCtr;
    int onResumeCtr;
    int onPauseCtr;
    int onStopCtr;
    int onRestartCtr;
    int onDestroyCtr;

    //TextViews
    TextView tv_onCreate;
    TextView tv_onStart;
    TextView tv_onResume;
    TextView tv_onPause;
    TextView tv_onStop;
    TextView tv_onRestart;
    TextView tv_onDestroy;

    //Shared Prefs
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        // no editor needed we're reading values
        prefs = getPreferences(MODE_PRIVATE);

        //Initialize counters
        onCreateCtr = prefs.getInt("onCreate", 0);
        onStartCtr = prefs.getInt("onStart", 0);
        onResumeCtr = prefs.getInt("onResume", 0);
        onPauseCtr = prefs.getInt("onPause", 0);
        onStopCtr = prefs.getInt("onStop", 0);
        onRestartCtr = prefs.getInt("onRestart", 0);
        onDestroyCtr = prefs.getInt("onDestroy", 0);

        //Initialize views
        tv_onCreate = (TextView)findViewById(R.id.create);
        tv_onStart = (TextView)findViewById(R.id.start);
        tv_onResume = (TextView)findViewById(R.id.resume);
        tv_onPause = (TextView)findViewById(R.id.pause);
        tv_onStop = (TextView)findViewById(R.id.stop);
        tv_onRestart = (TextView)findViewById(R.id.restart);
        tv_onDestroy = (TextView)findViewById(R.id.destroy);

        //Log cat print out
        Log.i(TAG, "onCreate called");

        //update the appropriate count variable
        onCreateCtr++;

        String str = getString(R.string.onCreate) + onCreateCtr;

        //update the view
        tv_onCreate.setText(str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_one, menu);
        return true;
    }

    // lifecycle callback overrides

    @Override
    public void onStart()
    {
        super.onStart();

        //Log cat print out
        Log.i(TAG, "onStart called");

        //update the appropriate count variable
        onStartCtr++;

        String str = getString(R.string.onStart) + onStartCtr;

        //update the view
        tv_onStart.setText(str);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        //Log cat print out
        Log.i(TAG, "onResume called");

        //update the appropriate count variable
        onResumeCtr++;

        String str = getString(R.string.onResume) + onResumeCtr;

        //update the view
        tv_onResume.setText(str);
    }

    @Override
    public void onPause()
    {
        super.onPause();

        //Log cat print out
        Log.i(TAG, "onPause called");

        //update the appropriate count variable
        onPauseCtr++;

        String str = getString(R.string.onPause) + onPauseCtr;

        //update the view
        tv_onPause.setText(str);

        SharedPreferences.Editor editor = prefs.edit();

        // set the key/value pairs
        editor.putInt("onCreate", onCreateCtr);
        editor.putInt("onStart", onStartCtr);
        editor.putInt("onResume", onResumeCtr);
        editor.putInt("onPause", onPauseCtr);
        editor.putInt("onStop", onStopCtr);
        editor.putInt("onRestart", onRestartCtr);
        editor.putInt("onDestroy", onDestroyCtr);

        // don't forget to commit the changes
        editor.commit();
    }

    @Override
    public void onStop()
    {
        super.onStop();

        //Log cat print out
        Log.i(TAG, "onStop called");

        //update the appropriate count variable
        onStopCtr++;

        String str = getString(R.string.onStop) + onStopCtr;

        //update the view
        tv_onStop.setText(str);
    }

    @Override
    public void onRestart()
    {
        super.onRestart();

        //Log cat print out
        Log.i(TAG, "onRestart called");

        //update the appropriate count variable
        onRestartCtr++;

        String str = getString(R.string.onRestart) + onRestartCtr;

        //update the view
        tv_onRestart.setText(str);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        //Log cat print out
        Log.i(TAG, "onDestroy called");

        //update the appropriate count variable
        onDestroyCtr++;

        String str = getString(R.string.onDestroy) + onDestroyCtr;

        //update the view
        tv_onDestroy.setText(str);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        //Log cat print out
        Log.i(TAG, "onSaveInstanceState called");

        //Save state
        outState.putInt("onCreate", onCreateCtr);
        outState.putInt("onStart", onStartCtr);
        outState.putInt("onResume", onResumeCtr);
        outState.putInt("onPause", onPauseCtr);
        outState.putInt("onStop", onStopCtr);
        outState.putInt("onRestart", onRestartCtr);
        outState.putInt("onDestroy", onDestroyCtr);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState)
    {
        super.onRestoreInstanceState(inState);

        //Log cat print out
        Log.i(TAG, "onRestoreInstanceState called");

        //Restore state
        onCreateCtr = inState.getInt("onCreate", 0);
        onStartCtr = inState.getInt("onStart", 0);
        onResumeCtr = inState.getInt("onResume", 0);
        onPauseCtr = inState.getInt("onPause", 0);
        onStopCtr = inState.getInt("onStop", 0);
        onRestartCtr = inState.getInt("onRestart", 0);
        onDestroyCtr = inState.getInt("onDestroy", 0);
    }

    public void launchActivityTwo(View view)
    {
        Intent i = new Intent(this, ActivityTwo.class);

        startActivity(i);
    }
}

