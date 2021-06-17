package com.example.androidpracticalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticalexam.adapter.CountryListAdapter
import com.example.androidpracticalexam.model.Country
import kotlinx.android.synthetic.main.activity_main.recyclerViewCountry
import com.example.androidpracticalexam.service.CountryService
import com.example.androidpracticalexam.service.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {

    private val countryService: CountryService by lazy {
        RetrofitClient.countryService
    }

    var tempCountryRecord = mutableListOf<Country>()
    var countryRecord = mutableListOf<Country>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        countryService.getAllCountries().enqueue(object: retrofit2.Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful){
                    val records = response.body()
                    countryRecord = records as MutableList<Country>
                    loadCountry(tempCountryRecord)
                    tempCountryRecord.addAll(countryRecord)
                    recyclerViewCountry.adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d("Error", t.localizedMessage)
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempCountryRecord.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    countryRecord.forEach {
                        if (it.name.toLowerCase(Locale.getDefault()).contains(searchText) || it.alpha2Code.toLowerCase(Locale.getDefault()).contains(searchText) || it.alpha3Code.toLowerCase(Locale.getDefault()).contains(searchText))
                            tempCountryRecord.add(it)
                    }
                    recyclerViewCountry.adapter?.notifyDataSetChanged()
                }else {
                    tempCountryRecord.clear()
                    tempCountryRecord.addAll(countryRecord)
                    recyclerViewCountry.adapter?.notifyDataSetChanged()
                }
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
    private fun loadCountry(country: MutableList<Country>) {
        recyclerViewCountry.layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCountry.adapter = CountryListAdapter(applicationContext,  country)
    }
}