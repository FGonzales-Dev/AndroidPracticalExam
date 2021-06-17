package com.example.androidpracticalexam.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofitCountry: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.eu/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val countryService: CountryService by lazy {
        retrofitCountry.create(CountryService::class.java)
    }
}