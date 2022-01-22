package com.kotlin.persian_tools.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.persian_tools.R
import com.kotlin.persian_tools.adapter.CountryNumberAdapter
import com.kotlin.persian_tools.services.DataSource

class CountryNumberActivity : AppCompatActivity() {
    lateinit var adapter: CountryNumberAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_number)
        adapter= CountryNumberAdapter(this,DataSource.countryNumber)
        var countryList:RecyclerView=findViewById(R.id.country_list)
        countryList.adapter=adapter
        val layoutManger=LinearLayoutManager(this)
        countryList.layoutManager=layoutManger
        countryList.setHasFixedSize(true)
    }
}