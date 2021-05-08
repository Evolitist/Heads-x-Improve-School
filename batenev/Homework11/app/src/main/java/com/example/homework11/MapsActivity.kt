package com.example.homework11

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.homework11.databinding.ActivityMapsBinding
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var shouldStartUpdatingLocations = true

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }
    private val locationUpdatesCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(
                        locationResult.lastLocation.latitude,
                        locationResult.lastLocation.longitude
                    ),
                    8F
                )
            )
        }
    }
    private val locationRequest by lazy {
        LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
            interval = 1000
            fastestInterval = 1000
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            if (checkGeoPermission()) {
                startUpdatingLocations()
            }
        }

        setContentView(binding.root)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_find -> {
                val palaceSquareLocation = LatLng(59.9389204, 30.313383)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(palaceSquareLocation, 18F))
                mMap.addMarker(
                    MarkerOptions()
                        .position(palaceSquareLocation)
                        .title("Дворцовая площадь")
                )
                return true
            }
        }
        return false
    }

    private fun checkGeoPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this@MapsActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                FINE_LOCATION_REQUEST_CODE
            )
            false
        } else {
            true
        }
    }

    @SuppressLint("MissingPermission")
    private fun startUpdatingLocations() {
        binding.fab.apply {
            if (shouldStartUpdatingLocations) {
                setImageResource(R.drawable.ic_baseline_gps_fixed_24)
                mMap.uiSettings.setAllGesturesEnabled(false)
                mMap.isMyLocationEnabled = true
                fusedLocationClient.requestLocationUpdates(
                    locationRequest,
                    locationUpdatesCallback,
                    Looper.getMainLooper()
                )
                shouldStartUpdatingLocations = false
            } else {
                setImageResource(R.drawable.ic_baseline_gps_not_fixed_24)
                mMap.isMyLocationEnabled = false
                mMap.uiSettings.setAllGesturesEnabled(true)
                fusedLocationClient.removeLocationUpdates(locationUpdatesCallback)
                shouldStartUpdatingLocations = true
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == FINE_LOCATION_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startUpdatingLocations()
            }
        }
    }

    companion object {
        private const val FINE_LOCATION_REQUEST_CODE = 111
    }
}