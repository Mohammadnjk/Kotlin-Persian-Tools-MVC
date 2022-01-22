package com.kotlin.persian_tools.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.persian_tools.R

class CalculatorActivity : AppCompatActivity() {
    var isNewOperation = true
    var selectOperator = ""
    var oldNumber = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun cliclButton(view: View) {
        if (isNewOperation) {
            cleanNumber()
        }
        isNewOperation = false
        var selectButtom = view as Button
        var showNumber = findViewById<EditText>(R.id.showNumber)
        var currentNumber = showNumber.text.toString()
        var newNumber = setCurracture(currentNumber, selectButtom)
        showNumber.setText(newNumber)
    }

    fun setCurracture(oldNumber: String, selectButton: Button): String {
        var number = oldNumber
        var btn_0: Button = findViewById(R.id.btn_0)
        var btn_1: Button = findViewById(R.id.btn_1)
        var btn_2: Button = findViewById(R.id.btn_2)
        var btn_3: Button = findViewById(R.id.btn_3)
        var btn_4: Button = findViewById(R.id.btn_4)
        var btn_5: Button = findViewById(R.id.btn_5)
        var btn_6: Button = findViewById(R.id.btn_6)
        var btn_7: Button = findViewById(R.id.btn_7)
        var btn_8: Button = findViewById(R.id.btn_8)
        var btn_9: Button = findViewById(R.id.btn_9)
        var btnDot: Button = findViewById(R.id.btn_dot)
        var btnClear: Button = findViewById(R.id.btn_clear)
        var btnSing: Button = findViewById(R.id.btn_sing)
        when (selectButton.id) {
            btn_0.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    number += "0"
                }
            }
            btn_1.id -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }
            btn_1.id -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }
            btn_2.id -> {
                if (number == "0" || number == "") {
                    number = "2"
                } else {
                    number += "2"
                }
            }
            btn_3.id -> {
                if (number == "0" || number == "") {
                    number = "3"
                } else {
                    number += "3"
                }
            }
            btn_4.id -> {
                if (number == "0" || number == "") {
                    number = "4"
                } else {
                    number += "4"
                }
            }
            btn_5.id -> {
                if (number == "0" || number == "") {
                    number = "5"
                } else {
                    number += "5"
                }
            }
            btn_6.id -> {
                if (number == "0" || number == "") {
                    number = "6"
                } else {
                    number += "6"
                }
            }
            btn_7.id -> {
                if (number == "0" || number == "") {
                    number = "7"
                } else {
                    number += "7"
                }
            }
            btn_8.id -> {
                if (number == "0" || number == "") {
                    number = "8"
                } else {
                    number += "8"
                }
            }
            btn_9.id -> {
                if (number == "0" || number == "") {
                    number = "9"
                } else {
                    number += "9"
                }
            }
            btnDot.id -> {
                if (number == "") {
                    number = "0."
                } else {
                    if (number.indexOf('.') == -1) {
                        number += "."
                    }
                }
            }
            btnSing.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    if (number.first() == '-') {
                        number = number.substring(1, number.lastIndex + 1)
                    } else {
                        number = "-$number"
                    }
                }
            }
            btnClear.id -> {
                number = "0"
            }
        }
        return number
    }

    fun cleanNumber() {
        var showNumber: EditText = findViewById(R.id.showNumber)
        showNumber.setText("0")
    }

    fun operationButton(view: View) {
        var selectButton = view as View
        var showNumber: EditText = findViewById(R.id.showNumber)
        var btnPlus: Button = findViewById(R.id.btnPlus)
        var btnDivision: Button = findViewById(R.id.btnDivision)
        var btnMultiplication: Button = findViewById(R.id.btnMultiplication)
        var btnSubmission: Button = findViewById(R.id.btnSubmission)

        when (selectButton.id) {
            btnPlus.id -> {
                selectOperator = "+"
            }
            btnMultiplication.id -> {
                selectOperator = "*"
            }
            btnDivision.id -> {
                selectOperator = "/"
            }
            btnSubmission.id -> {
                selectOperator = "-"
            }
        }
        isNewOperation = true
        oldNumber = showNumber.text.toString()
    }

    fun equalsEvent(view: View) {
        view as Button
        var showNumber: EditText = findViewById(R.id.showNumber)
        var newNumber = showNumber.text.toString().toDouble()
        var answer: Double? = null
        if (selectOperator != "" && oldNumber != "") {
            when (selectOperator) {
                "" -> {
                    answer = newNumber
                }
                "/" -> {
                    answer = oldNumber.toDouble() / newNumber
                }
                "+" -> {
                    answer = oldNumber.toDouble() + newNumber
                }
                "-" -> {
                    answer = oldNumber.toDouble() - newNumber
                }
                "*" -> {
                    answer = oldNumber.toDouble() * newNumber
                }
            }
        }
        showNumber.setText(answer.toString())
        isNewOperation = true
        selectOperator = ""
        oldNumber = ""
    }
    fun clickPercentage(view: View) {
        var showNumber: EditText = findViewById(R.id.showNumber)
        var number = showNumber.text.toString().toDouble()
        var percentage = number / 100
        showNumber.setText(percentage.toString())
        isNewOperation = true
    }
}