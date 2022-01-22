package com.kotlin.persian_tools.model

class CountryNumber(val country:String,val number:String) {
    override fun toString(): String {
            return country+number
    }
}