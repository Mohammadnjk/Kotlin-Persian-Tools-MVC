package com.kotlin.persian_tools.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kotlin.persian_tools.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_start=findViewById<Button>(R.id.btn_start)
        btn_start.setOnClickListener {
            val selecActivity=Intent(this, SelectorActivity::class.java)
            startActivity(selecActivity)

        }

    }
}