package com.app.domain.model.get_place_id.request

data class Geo(
    val query: String,
    val language: String = "fa-IR",
    val locationType: String = "locale",
)
