package com.example.week2task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FragmentsStack : AppCompatActivity() {

    private lateinit var btn_add : Button
    private lateinit var btn_remove : Button
    private val fragmentManager = supportFragmentManager

    companion object{
        var count = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_stack)
        btn_add = findViewById(R.id.btn_add)
        btn_remove = findViewById(R.id.btn_remove)


        /**
         * Keeps count of every change that occurs in the stack
         * and assigns the value of the count to a static count variable
         */

        fragmentManager.addOnBackStackChangedListener (){
            count = fragmentManager.backStackEntryCount
        }

        //Button is clicked to add a fragment to the stack

        btn_add.setOnClickListener{
            addFragment()
        }

        //Button is clicked to remove a fragment from the stack
        btn_remove.setOnClickListener {
            fragmentManager.popBackStack()
        }

        // Setting up the actionbar
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * Starts a transaction on the fragment manager
     * Creates an instance of the class to be added to the stack
     * Adds the fragment to the container
     * Adds the fragment to the stack
     */
    private fun addFragment(){
        fragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainer, FragmentTemp())
            addToBackStack(null)
            commit()

        }
    }
}