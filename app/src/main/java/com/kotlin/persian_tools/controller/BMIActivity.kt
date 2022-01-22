package com.kotlin.persian_tools.controller

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.kotlin.persian_tools.R

class BMIActivity : AppCompatActivity() {
    var weight = ""
    var height = ""
    var result: Double? = null
    var isFinishResult = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)
    }

    fun getData() {
        var bmiWeight: EditText = findViewById(R.id.get_weight)
        if (weight == "") {
            weight = bmiWeight.text.toString()
        }
        var bmiHeight: EditText = findViewById(R.id.get_height)
        if (height == "") {
            height = bmiHeight.text.toString()
        }
    }

    fun computingBmi() {
        if (height != "" || weight != "") {
            var heightResult = height.toDouble()
            var weightResult = weight.toDouble()
            var answer: Double? = null
            var heigtResultMeter = heightResult / 100
            answer = weightResult / (heigtResultMeter * heigtResultMeter)
            result = answer
        } else  {
            Toast.makeText(this, "شما هنوز قد و وزن را وارد نکرده اید", Toast.LENGTH_LONG).show()
        }
    }

    fun showResult(view: View) {
        view as Button
        clearResult()
        getData()
        computingBmi()
        var resultText: TextView = findViewById(R.id.bmi_resulat)
        var resultNumber: TextView = findViewById(R.id.bmi_number)
        if (weight!=""||height!="") {
            resultNumber.text=result.toString()
            when (result!!) {
                in 0.0..18.5 -> {
                    resultNumber.setTextColor(Color.parseColor("#B30000"))
                    resultText.text = "شما بیش از انداره لاغر هستید "
                }
                in 18.5..25.0 -> {
                    resultNumber.setTextColor(Color.parseColor("#00B300"))
                    resultText.text = "وزن شما ایده آل است "
                }
                in 25.0..29.9 -> {
                    resultNumber.setTextColor(Color.parseColor("#B38F00"))
                    resultText.text = "شما اضافه وزن دارید "
                }
                else -> {
                    resultNumber.setTextColor(Color.parseColor("#B30000"))
                    resultText.text = "شما بیش از انداره چاق هستید "
                }
            }
        }
        isFinishResult = true
    }

    fun clearResult() {
        if (isFinishResult) {
            height = ""
            weight = ""
        }
        isFinishResult = false
    }

}