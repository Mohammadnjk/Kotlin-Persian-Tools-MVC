package com.kotlin.persian_tools.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.kotlin.persian_tools.R

class SelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)

        var cal_btn=findViewById<ImageButton>(R.id.cal_btn)
        cal_btn.setOnClickListener {
            val calculatorActivity=Intent(this, CalculatorActivity::class.java)
            startActivity(calculatorActivity)
        }
        var change_btn=findViewById<ImageButton>(R.id.change_btn)
        change_btn.setOnClickListener {
            val changeActivity = Intent(this, ChangeActivity::class.java)
            startActivity(changeActivity)
        }
        var bmi_btn=findViewById<ImageButton>(R.id.bmi_btn)
        bmi_btn.setOnClickListener {
            val bmiActivity=Intent(this, BMIActivity::class.java)
            startActivity(bmiActivity)
        }
        var number_btn=findViewById<ImageButton>(R.id.number_btn)
        number_btn.setOnClickListener {
            val numberActivity=Intent(this, CountryNumberActivity::class.java)
            startActivity(numberActivity)
        }
    }
    fun exitButton(view:View){
        view as Button
//       var exitButton :Button=findViewById(R.id.btn_exit)
         finishAffinity()
    }
}