package com.kotlin.persian_tools.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.kotlin.persian_tools.R

class ChangeActivity : AppCompatActivity() {
    var money = ""
    var profit = ""
    var result = ""
    var isFinishResult = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)
    }

    fun getMoney() {
        var moneyAmount: EditText = findViewById(R.id.get_height)
        var moneyProfit: EditText = findViewById(R.id.get_profit)

        if (money == "" || profit == "") {
            money = moneyAmount.text.toString()
            profit = moneyProfit.text.toString()
        }
    }

    fun computingProfit() {
        if (money != "") {
            var moneyAmount = money.toDouble()
            var profitAmount = profit.toDouble()
            var answer: Double? = null
            var yearProfitAmount = profitAmount / 100
            answer = (moneyAmount * yearProfitAmount) / 12
            result = answer.toString()
        } else {
            Toast.makeText(this, "شما هنوز پول و نرخ سود  را وارد نکرده اید", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun showResult(view: View) {
        view as Button
        clearResult()
        getMoney()
        computingProfit()
        var showResult: TextView = findViewById(R.id.show_result)
        showResult.text = result
        isFinishResult = true
    }

    fun clearResult() {
        if (isFinishResult) {
            money = ""
            profit = ""
        }
        isFinishResult = false
    }
}