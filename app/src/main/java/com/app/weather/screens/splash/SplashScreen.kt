package com.app.weather.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.app.weather.R
import com.app.weather.screens.destinations.MainScreenDestination
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalPermissionsApi
@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
        Button(onClick = {
            navigator.navigate(
                MainScreenDestination()
            )
        }) {

        }
}
