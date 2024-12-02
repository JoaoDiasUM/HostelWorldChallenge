package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing

import com.example.hostelworldchallenge.feature_property_listing.domain.model.PropertyEntity
import com.example.hostelworldchallenge.feature_property_listing.domain.model.RatesEntity

data class PropertyListingViewState(
    val isLoading: Boolean = false,
    val propertyList: MutableList<PropertyEntity> = mutableListOf(),
    val rates: RatesEntity? = null,
    val networkStats: Long? = 0, // Consider showing an average by request in a new screen
    val error: String? = null,
)