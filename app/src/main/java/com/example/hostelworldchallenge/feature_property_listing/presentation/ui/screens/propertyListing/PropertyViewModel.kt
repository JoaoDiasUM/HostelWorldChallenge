package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetProperties
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetRatesUseCase
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetStatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val getPropertiesUseCase: GetProperties,
    private val getRatesUseCase: GetRatesUseCase,
    private val getStatsUseCase: GetStatsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(PropertyListingViewState())
    val state: StateFlow<PropertyListingViewState> = _state

    init {
        getProperties()
        getRates()
    }

    private fun getProperties() {
        getPropertiesUseCase().onEach { result ->
            _state.update {
                when (result) {
                    is Resource.Loading -> it.copy(isLoading = true)
                    is Resource.Error -> it.copy(
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )

                    is Resource.Success -> {
                        result.data?.responseTime?.let { it1 -> getStats("load-details", it1) }

                        it.copy(
                            isLoading = false,
                            propertyList = result.data?.properties ?: mutableListOf(),
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getRates() {
        getRatesUseCase().onEach { result ->
            _state.update {
                when (result) {
                    is Resource.Loading -> it.copy(isLoading = false)
                    is Resource.Error -> it.copy(
                        error = result.message ?: "An unexpected error occurred"
                    )

                    is Resource.Success -> {
                        result.data?.responseTime?.let { it1 -> getStats("load-rates", it1) }

                        it.copy(
                            rates = result.data,
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getStats(action: String, duration: Long) {
        getStatsUseCase(action, duration).onEach { result ->
            _state.update {
                when (result) {
                    is Resource.Loading -> it.copy(isLoading = false)
                    is Resource.Error -> it.copy(
                        error = result.message ?: "An unexpected error occurred"
                    )

                    is Resource.Success -> it.copy(
                        networkStats = result.data,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}