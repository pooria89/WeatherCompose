package com.app.data.model

import com.airbnb.lottie.compose.LottieAnimatable

data class WeatherModel(
    val id: Int,
    val image: Int=0,
    val title: String,
    val count: String,
)
