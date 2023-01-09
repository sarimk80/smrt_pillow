package com.example.smartpilow.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    var baseUrl = "https://api.thingspeak.com/"

    fun getInstance() : Retrofit{
        return  Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}