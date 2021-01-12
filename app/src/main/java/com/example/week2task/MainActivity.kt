package com.example.week2task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // Variables to be initialized later in the program
    lateinit var activityLifeCycleBtn : Button
    lateinit var fragmentStackBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityLifeCycleBtn = findViewById(R.id.btn_task_1)
        fragmentStackBtn = findViewById(R.id.btn_task_2)

        // This button takes you to the first task activity on a click event
        activityLifeCycleBtn.setOnClickListener {
            startActivity(Intent(this, ActivityLifeCycle::class.java))
        }

        // This button takes you to the second task activity on a click event
        fragmentStackBtn.setOnClickListener {
            startActivity(Intent(this, FragmentsStack::class.java))
        }
    }
}