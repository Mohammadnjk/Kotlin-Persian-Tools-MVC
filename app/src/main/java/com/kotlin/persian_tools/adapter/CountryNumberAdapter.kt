package com.kotlin.persian_tools.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.persian_tools.R
import com.kotlin.persian_tools.model.CountryNumber

class CountryNumberAdapter(val contex: Context, val countryNumber: List<CountryNumber>) :
    RecyclerView.Adapter<CountryNumberAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryNumberAdapter.Holder {
        val view = LayoutInflater.from(contex).inflate(R.layout.country_list, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: CountryNumberAdapter.Holder, position: Int) {
        holder.bindCountryNumber(countryNumber[position], contex)
    }

    override fun getItemCount(): Int {
        return countryNumber.count()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val countryNumbers: TextView = itemView.findViewById(R.id.country_number)
        fun bindCountryNumber(countryNumber: CountryNumber, contex: Context) {
            countryName?.text = countryNumber.country
            countryNumbers?.text = countryNumber.number
        }
    }
}