package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener(){
            val Intent = Intent(this,InputData::class.java)
            startActivity(Intent)
        }

        binding.btn2.setOnClickListener(){
            val Intent1 = Intent(this,InputData::class.java)
            startActivity(Intent1)
        }


    }
}