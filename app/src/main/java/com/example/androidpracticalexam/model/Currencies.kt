package com.example.androidpracticalexam.model

import com.google.gson.annotations.SerializedName

data class Currencies(
    @SerializedName("code")
    var code: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("symbol")
    var symbol: String,
)