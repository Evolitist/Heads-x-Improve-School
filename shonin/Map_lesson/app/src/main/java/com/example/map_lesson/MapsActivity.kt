package com.example.map_lesson

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.map_lesson.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener {

    private lateinit var mMap: GoogleMap
    private var ccheck = true

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMapsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.floatingActionButton.setOnClickListener {
            if (ccheck == true) {
                val myLoc = mMap.myLocation
                val me = LatLng(myLoc.latitude, myLoc.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(me, 14.0F))
                mMap.uiSettings.setAllGesturesEnabled(false)
                ccheck = false
            } else {
                mMap.uiSettings.setAllGesturesEnabled(true)
                mMap.uiSettings.isMyLocationButtonEnabled = false
                mMap.uiSettings.isRotateGesturesEnabled = false
                mMap.uiSettings.isTiltGesturesEnabled = false
                ccheck = true
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        enableMyLocation()
        mMap.isMyLocationEnabled = true
        mMap.setOnMyLocationButtonClickListener(this)
        mMap.uiSettings.isMyLocationButtonEnabled = false
        mMap.setOnMyLocationClickListener(this)
        mMap.uiSettings.isRotateGesturesEnabled = false
        mMap.uiSettings.isTiltGesturesEnabled = false
    }

    private fun enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.setMyLocationEnabled(true)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableMyLocation()
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.god_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.go -> {
                if (ccheck == true) {
                    val peter = LatLng(59.9389, 30.3152)
                    mMap.addMarker(
                        MarkerOptions().position(peter).title("Marker in Peter's Burger")
                    )
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(peter, 14.0F))
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onMyLocationButtonClick(): Boolean {
        return true
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Current location:\n$p0", Toast.LENGTH_LONG)
            .show()
    }


}