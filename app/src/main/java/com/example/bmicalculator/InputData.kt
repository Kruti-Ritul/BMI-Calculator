package com.example.bmicalculator

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.bmicalculator.databinding.InputDataBinding
import java.math.BigDecimal
import java.math.RoundingMode

class InputData : AppCompatActivity() {
    private lateinit var binding: InputDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = InputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnnext.setOnClickListener(){



            if (binding.textHeight.text.isNotEmpty() && binding.textWeight.text.isNotEmpty()){
                val weight = binding.textWeight.text.toString().toDouble()
                val height = binding.textHeight.text.toString().toDouble()/100

                if(weight >= 0 && weight < 600 && height >= 0.50 && height < 2.5){
                    val intent = Intent(this@InputData, UnderWeight::class.java)
                    intent.putExtra("bmi", calculateBMI(weight, height))
                    startActivity(intent)

                }else{
                    if(binding.textWeight.text.isNullOrEmpty()){
                        Toast.makeText(this,"Weight is Empty",Toast.LENGTH_LONG).show()
                    }else{
                        if(binding.textHeight.text.isNullOrEmpty()){
                            Toast.makeText(this,"Height is Empty",Toast.LENGTH_LONG).show()
                        }
                    }
                }


            }

        }

    }
    private fun calculateBMI(weight:Double , height:Double) = BigDecimal(weight / (height * height))
        .setScale(2, RoundingMode.HALF_EVEN).toDouble()

}