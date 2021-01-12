package com.example.week2task

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView

class ActivityLifeCycle : AppCompatActivity() {
    private lateinit var activityStateTextView: TextView
    private lateinit var orientationTextView: TextView

    private var orientation = ""
    private val TAG: String = "MainActivity" // This variable is used when logging events to logcat
    private var count = 0 // This variable keeps count of each orientation change


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        activityStateTextView = findViewById(R.id.activityState)
        orientationTextView = findViewById(R.id.orientation)

        activityStateTextView.text = getString(R.string.activity_state, "onCreate")

        Log.d(TAG, "oncreate ")

        // Retrieving the states from the bundle
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("CURRENT_COUNT")
        }

        // Gets the current orientation of the screen and converts it to a string
        orientation = this.resources.configuration.orientation.toString()

        if (orientation == Configuration.ORIENTATION_LANDSCAPE.toString()) {
            count++
            orientationTextView.text = getString(R.string.config_change, "LandScape $count")
        } else {
            count++
            orientationTextView.text = getString(R.string.config_change, "Portrait $count")
        }
    }

    /**
     * This function is called when the activity loads to the foreground but not yet interactive with the user
     * It is overridden to display a text containing its state on the screen
     */
    override fun onStart() {
        super.onStart()

        /**
         * Adds the text to be displayed to a queue to be run after the specified amount of time is elapsed
         */
        Handler(Looper.getMainLooper()).postDelayed({

            //Action to be carried out
            activityStateTextView.text = getString(R.string.activity_state, "onStart")
        }, 1000)

        Log.d(TAG, "onStart ")
    }

    /**
     * This function is called the activity is fully loaded and users can interact with the activity
     * It is overridden to display a text containing its state on the screen
     */
    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            activityStateTextView.text = getString(R.string.activity_state, "onResume")
        }, 1300)
        Log.d(TAG,"onResume")

    }

    /**
     * This function is called when the activity is moving to the background and is slightly visible to the user
     * It is overridden to display a text containing its state on the screen
     */
    override fun onPause() {
        super.onPause()
        activityStateTextView.text = getString(R.string.activity_state, "onPause")
        Log.d(TAG,"onPause")
    }

    /**
     * This function is called after the activity moves to the background and is no longer visible to the user
     * It is overridden to display a text containing its state on the screen
     */
    override fun onStop() {
        super.onStop()
        activityStateTextView.text = getString(R.string.activity_state, "onStop")
        Log.d(TAG,"onStop")
    }

    /**
     * As the activity returns to the foreground, this function is called
     * It is overridden to display a text containing its state on the screen
     */
    override fun onRestart() {
        super.onRestart()

        Handler(Looper.getMainLooper()).postDelayed({
            activityStateTextView.text = getString(R.string.activity_state, "onRestart")
        }, 700)

        Log.d(TAG, "onRestart ")
    }

    /**
     * This function is called after the activity is closed. It is also called when an orientation change occurs
     * It is overridden to display a text containing its state on the screen
     */
    override fun onDestroy() {
        super.onDestroy()
        activityStateTextView.text = getString(R.string.ondestroy)
        Log.d(TAG,"onDestroy")
    }

    /**
     * Saves the current state of the activity (including variables) in a bundle before destroy() is called
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CURRENT_COUNT", count)
    }
}