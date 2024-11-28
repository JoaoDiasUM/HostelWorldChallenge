package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val getPropertiesUseCase: GetProperties
): ViewModel() {

    init {
       getProperties()
    }

    private fun getProperties() {
        getPropertiesUseCase().onEach { result ->
        }.launchIn(viewModelScope)
    }
}