package com.app.weather.screens.main

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.airbnb.lottie.compose.*
import com.app.data.model.WeatherModel
import com.app.utils.ext.findActivity
import com.app.weather.R
import com.app.weather.component.Toolbar
import com.app.weather.ui.theme.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.gms.location.LocationServices
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        BackgroundColor,
                        BackgroundColorGradiant
                    )
                )
            )
    ) {
        Toolbar()
        GetWeatherItems()
    }
}

fun getCurrentLocation(context: Context) {
    val location = context.findActivity()
        ?.let { LocationServices.getFusedLocationProviderClient(it) }
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        location?.lastLocation?.addOnSuccessListener { location ->
            Log.e("gpssss", "Latitude\n ${location.latitude}")
            Log.e("gpssss", "Longitude\n${location.longitude}")
//        viewModel.currentWeather(
//            lat = location.latitude.toString(),
//            lon = location.longitude.toString()
//        )
        }
        return
    }

}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun GetWeatherItems() {

    val context = LocalContext.current

    var result by remember { mutableStateOf<Boolean?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        result = it
    }

    if (result == true) {
        getCurrentLocation(context)
    } else if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        SideEffect {
            launcher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
    }

    LazyColumn(
        modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 7.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            val composition by rememberLottieComposition(
                LottieCompositionSpec
                    .RawRes(R.raw.weather_rainy)
            )

            val lottieAnimation by animateLottieCompositionAsState(
                composition,
                iterations = LottieConstants.IterateForever,
                speed = 1f,
                restartOnPlay = true
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(modifier = Modifier.padding(all = 25.dp)) {
                    Text(
                        text = "Iran",
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Valiasr Square",
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Tue,Jan 30",
                        style = TextStyle(
                            color = TextGrayColor,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                        )
                    )

                    Row(modifier = Modifier.padding(all = 25.dp)) {
                        LottieAnimation(
                            modifier = Modifier
                                .weight(1f)
                                .height(150.dp),
                            composition = composition,
                            progress = { lottieAnimation })
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "19 °C",
                                style = TextStyle(
                                    color = TextBlackColor,
                                    fontSize = 40.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Rainy",
                                style = TextStyle(
                                    color = TextBlackColor,
                                    fontSize = 30.sp,
                                    fontStyle = FontStyle.Normal,
                                )
                            )
                        }
                    }

                    getInformations()
                }
            }
        }

        items(getInformations()) {
            Card(
                backgroundColor = WhiteWithOpacityFifty,
                elevation = 0.dp,
                modifier = Modifier
                    .padding(3.dp)
                    .height(70.dp)
                    .clip(shape = RoundedCornerShape(30))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        backgroundColor = Color.White,
                        elevation = 0.dp,
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .clip(shape = RoundedCornerShape(30))
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(id = it.image),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = it.title,
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = it.count,
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoadUi() {
    MainScreen()
}

fun getInformations() = listOf(
    WeatherModel(id = 1, image = R.drawable.ic_wind, title = "Wind", count = "19km/h"),
    WeatherModel(id = 2, image = R.drawable.ic_umbrella, title = "Rainfall", count = "3cm"),
    WeatherModel(id = 3, image = R.drawable.ic_humidity, title = "Humidity", count = "64%")
)







