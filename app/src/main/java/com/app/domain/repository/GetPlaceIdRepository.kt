package com.app.domain.repository

import com.app.domain.model.get_place_id.request.PlaceId
import com.app.domain.model.get_place_id.response.PlaceIdModel

interface GetPlaceIdRepository {

    suspend fun getPlaceId(placeId: MutableList<PlaceId>): PlaceIdModel

}