package com.app.utils.ext

import android.content.Context
import android.content.ContextWrapper
import android.location.LocationManager
import androidx.activity.ComponentActivity


fun Context.isLocationEnabled(): Boolean {
    val locationManager: LocationManager =
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
        LocationManager.NETWORK_PROVIDER
    )
}

fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper    -> baseContext.findActivity()
    else                 -> null
}