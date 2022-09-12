package com.app.weather.screens.main

import com.app.domain.model.get_place_id.response.PlaceIdModel

data class GetPlaceIdState(
    val isLoading: Boolean = false,
    val placeId: PlaceIdModel? = null,
    val error: String = ""
)