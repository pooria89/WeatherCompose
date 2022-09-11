package com.app.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.weather.component.Toolbar
import com.app.weather.screens.NavGraphs
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPermissionsApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}

