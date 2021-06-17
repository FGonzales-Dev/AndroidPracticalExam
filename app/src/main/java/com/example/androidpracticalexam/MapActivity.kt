package com.example.androidpracticalexam

import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticalexam.adapter.CountryListAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        p0.addMarker(
            MarkerOptions()
                .position(
                    LatLng(
                        CountryListAdapter.countrylat!!.toDouble(),
                        CountryListAdapter.countrylng!!.toDouble()
                    )
                )
                .title("Marker")
        )


        p0.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    CountryListAdapter.countrylat!!.toDouble(),
                    CountryListAdapter.countrylng!!.toDouble()
                ), 5.0f
            )
        )
    }
}