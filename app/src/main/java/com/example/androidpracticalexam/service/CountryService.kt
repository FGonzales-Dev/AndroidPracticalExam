package com.example.androidpracticalexam.service

import com.example.androidpracticalexam.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface CountryService {
    @GET("rest/v2/all")
    fun getAllCountries():Call<List<Country>>
}

