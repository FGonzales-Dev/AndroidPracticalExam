package com.example.androidpracticalexam.model

import com.google.gson.annotations.SerializedName

data class Language (
    @SerializedName("name")
    var name: String,
    @SerializedName("nativeName")
    var nativeName: String,

    )