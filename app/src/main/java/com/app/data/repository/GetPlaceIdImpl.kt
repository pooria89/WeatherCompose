package com.app.data.repository

import com.app.data.remote.ApiService
import com.app.domain.model.get_place_id.request.PlaceId
import com.app.domain.model.get_place_id.response.PlaceIdModel
import com.app.domain.repository.GetPlaceIdRepository
import javax.inject.Inject

class GetPlaceIdImpl @Inject constructor(
    private val api: ApiService
) : GetPlaceIdRepository {

    override suspend fun getPlaceId(placeId: MutableList<PlaceId>): PlaceIdModel {
        return api.getPlaceId(placeId)
    }

}