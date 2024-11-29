package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val getPropertiesUseCase: GetProperties
) : ViewModel() {

    private val _state = MutableStateFlow(PropertyListingViewState())
    val state: StateFlow<PropertyListingViewState> = _state

    init {
        getProperties()
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

                    is Resource.Success -> it.copy(
                        propertyList = result.data ?: mutableListOf(),
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}