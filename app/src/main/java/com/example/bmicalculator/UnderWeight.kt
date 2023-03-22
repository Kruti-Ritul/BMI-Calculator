package com.example.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.content.ContextCompat
import com.example.bmicalculator.databinding.ActivityUnderWeightBinding

class UnderWeight : AppCompatActivity() {
    private lateinit var binding: ActivityUnderWeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUnderWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bmi = intent.getDoubleExtra("bmi",-1.0)
        if (bmi<=-1.0){
            Toast.makeText(this,"Invalid Entries ❗", Toast.LENGTH_LONG).show()
            //binding.containerR.visibility = View.GONE
        }
        else{
            binding.result.text = bmi.toString()
            if(bmi < 18.5){
                binding.containerR.setBackgroundResource(R.drawable.page3)
                binding.resultCard.setBackgroundResource(R.color.colorYYellow)
                binding.label.setTextColor(ContextCompat.getColor(this,R.color.colorBrown))
                binding.label.text = "You Are UnderWeight ❗❗❗"
                binding.info.text = "(normal range is 18.5 - 24.9)"
            }else{
                if(bmi > 25.9 && bmi < 30){
                    binding.containerR.setBackgroundResource(R.drawable.page4)
                    binding.resultCard.setBackgroundResource(R.color.colorLOrange)
                    binding.label.setTextColor(ContextCompat.getColor(this,R.color.colorRed))
                    binding.label.text = "You Are OverWeight ❗❗❗"
                    binding.info.text = "(normal range is 18.5 - 24.9)"
                }else{
                    if(bmi >= 30){
                        binding.containerR.setBackgroundResource(R.drawable.page5)
                        binding.resultCard.setBackgroundResource(R.color.colorOrange)
                        binding.label.setTextColor(ContextCompat.getColor(this,R.color.colorDRed))
                        binding.info.setTextColor(ContextCompat.getColor(this,R.color.colorGrey))
                        binding.label.text = "You Are Obese ❗❗❗"
                        binding.info.text = "(normal range is 18.5 - 24.9)"
                    }else{
                        if(bmi >= 18.5 && bmi < 30){
                            binding.containerR.setBackgroundResource(R.drawable.page2)
                            binding.resultCard.setBackgroundResource(R.color.colorGreen)
                            binding.label.setTextColor(ContextCompat.getColor(this,R.color.colorLGreen))
                            binding.label.text = "\uD83D\uDC4FYou Are Healthy"
                            binding.info.text = "(normal range is 18.5 - 24.9)"
                        }
                    }
                }
            }
        }
    }
}