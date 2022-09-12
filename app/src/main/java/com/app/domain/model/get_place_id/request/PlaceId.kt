package com.app.domain.model.get_place_id.request

data class PlaceId(
    val name: String = "getSunV3LocationSearchUrlConfig",
    val params: Geo,
)