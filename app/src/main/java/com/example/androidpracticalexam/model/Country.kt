package com.example.androidpracticalexam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Country(
    @SerializedName("name")
    var name: String,
    @SerializedName("alpha2Code")
    var alpha2Code: String,
    @SerializedName("alpha3Code")
    var alpha3Code: String,
    @SerializedName("flag")
    var flag: String,
    @SerializedName("capital")
    var capital: String,
    @SerializedName("latlng")
    var latlng:  List<String>,
    @SerializedName("region")
    var region: String,
    @SerializedName("population")
    var population: String,
    @SerializedName("callingCodes")
    var callingCodes:  List<String>,
    @SerializedName("currencies")
    var currencies: @RawValue List<Currencies>,
    @SerializedName("languages")
    var languages:  @RawValue List<Language>,
    @SerializedName("borders")
    var borders: List<String>,

    ) : Parcelable