package com.app.domain.use_case

import com.app.common.Resource
import com.app.domain.model.get_place_id.request.PlaceId
import com.app.domain.model.get_place_id.response.PlaceIdModel
import com.app.domain.repository.GetPlaceIdRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlaceIdUseCase @Inject constructor(
    private val repository: GetPlaceIdRepository
) {

    operator fun invoke(placeId: MutableList<PlaceId>): Flow<Resource<PlaceIdModel>> = flow {
        try {
            emit(Resource.Loading<PlaceIdModel>())
            val coin = repository.getPlaceId(placeId)
            emit(Resource.Success<PlaceIdModel>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<PlaceIdModel>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<PlaceIdModel>("Couldn't reach server. Check your internet connection."))
        }
    }

}