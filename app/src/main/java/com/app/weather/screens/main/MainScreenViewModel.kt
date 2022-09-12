//package com.app.weather.screens.main
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.*
//import com.app.common.Resource
//import com.app.domain.model.get_place_id.request.PlaceId
//import com.app.domain.model.get_place_id.response.PlaceIdModel
//import com.app.domain.use_case.GetPlaceIdUseCase
//import kotlinx.coroutines.flow.launchIn
//import kotlinx.coroutines.flow.onEach
//import javax.inject.Inject
//
//class MainScreenViewModel @Inject constructor(
//    private val getPlaceIdUseCase: GetPlaceIdUseCase,
//    savedStateHandle: SavedStateHandle
//) : ViewModel() {
//
//    private val _state = mutableStateOf(GetPlaceIdState())
//    val state: State<GetPlaceIdState> = _state
//
//    init {
//        savedStateHandle.get<MutableList<PlaceId>>("0932840389,340934")?.let {
//            getPlaceId(it)
//        }
//    }
//
//    private fun getPlaceId(placeId: MutableList<PlaceId>) {
//        getPlaceIdUseCase(placeId).onEach { result ->
//            when (result) {
//                is Resource.Success -> {
////                    _state.value = GetPlaceIdState(coin = result.data)
//                }
//                is Resource.Error   -> {
//                    _state.value = GetPlaceIdState(
//                        error = result.message ?: "An unexpected error occured"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = GetPlaceIdState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
//}