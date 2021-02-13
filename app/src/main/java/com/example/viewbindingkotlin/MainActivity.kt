package com.example.viewbindingkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbindingkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //declare binding variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Create view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val view = binding.root
        setContentView(view)

        val mFragmentManager = supportFragmentManager
        val mBlankFragment = BlankFragment()
        val fragment = mFragmentManager.findFragmentByTag(BlankFragment::class.java.simpleName)

        //reference your view
        binding.testbindingtext1.text = "View Binding from MainActivity"

        binding.buttonbinding.setOnClickListener {
            Toast.makeText(this@MainActivity, "its ViewBinding from MainActivity", Toast.LENGTH_SHORT).show()
        }

        if (fragment !is BlankFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + BlankFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mBlankFragment, BlankFragment::class.java.simpleName)
                .commit()
        }

    }
}