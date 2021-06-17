package com.example.androidpracticalexam.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.androidpracticalexam.CountryDetailActivity
import com.example.androidpracticalexam.HelperFunction.loadSvg

import com.example.androidpracticalexam.R
import com.example.androidpracticalexam.model.Country
import kotlinx.android.synthetic.main.country_cardview.view.*
import java.io.Serializable


class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{

    private val name: TextView = itemView.countryName
    private val flag: ImageView = itemView.countryFlag
    fun bind(record: Country)
    {
        name.text = record.name
        flag.loadSvg(record.flag)
    }
}
class CountryListAdapter(
    private var context: Context,
    private var countryRecord: MutableList<Country>
)
    : RecyclerView.Adapter<MyHolder>() {
    companion object Details {
          var countryName : String? = null
        var countryFlag : String? = null
            var countryRegion : String? = null
        var countryCapital: String? = null
        var countryPopulation: String? = null
        var countryCurrencyName: String? = null
        var countryCurrencySymbol: String? = null
        var countryLanguageNativeName: String? = null
        var countryLanguageName: String? = null
        var countryBorders: String? = null
        var countryCallingCodes: String? = null
        var countrylat: String? = null
        var countrylng: String? = null
    }
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = layoutInflater.inflate(R.layout.country_cardview, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return countryRecord.size
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val record = countryRecord[position]


        holder.bind(record)

        holder.itemView.setOnClickListener {
            countryName = record.name
            countryFlag = record.flag
            countryRegion = record.region
            countryCapital = record.capital
            countryPopulation = record.population
            countryCurrencyName = record.currencies[0].name
            countryCurrencySymbol = record.currencies[0].symbol
            countryLanguageName = record.languages[0].name
            countryLanguageNativeName = record.languages[0].nativeName
            countryCallingCodes = record.callingCodes.toString()
            countrylat = record.latlng[0]
            countrylng = record.latlng[1]

            countryBorders  = record.borders.toMutableList().toString()

            val intent = Intent(Intent(context, CountryDetailActivity::class.java))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }


}




