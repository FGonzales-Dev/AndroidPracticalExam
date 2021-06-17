package com.example.androidpracticalexam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticalexam.HelperFunction.loadSvg
import com.example.androidpracticalexam.adapter.CountryListAdapter
import kotlinx.android.synthetic.main.activity_country_detail.*



class CountryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
        countryDetailFlag.loadSvg(CountryListAdapter.countryFlag.toString())
        countryDetailname.text = CountryListAdapter.countryName
        countryDetailcapital.text = CountryListAdapter.countryCapital
        countryDetailregion.text = CountryListAdapter.countryRegion
        countryDetailpopulation.text = CountryListAdapter.countryPopulation
       countryDetailCallingCodes.text = CountryListAdapter.countryCallingCodes
        countryDetailCurrencyName.text = CountryListAdapter.countryCurrencyName
        countryDetailCurrencySymbol.text = CountryListAdapter.countryCurrencySymbol
        countryDetailLanguageNativeName.text = CountryListAdapter.countryLanguageNativeName
        countryDetailLanguageName.text = CountryListAdapter.countryLanguageName
        countryDetailBorders.text = CountryListAdapter.countryBorders
        countryDetailLatitude.text = CountryListAdapter.countrylat
        countryDetailLongitude.text = CountryListAdapter.countrylng

        btnGoToMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }

}