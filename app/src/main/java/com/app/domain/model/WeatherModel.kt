package com.app.domain.model

data class WeatherModel(
    val id: Int,
    val image: Int=0,
    val title: String,
    val count: String,
)
