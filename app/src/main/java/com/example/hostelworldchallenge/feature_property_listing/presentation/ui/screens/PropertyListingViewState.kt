package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens

import com.example.hostelworldchallenge.feature_property_listing.data.model.Property

data class PropertyListingViewState(
    val isLoading: Boolean = false,
    val propertyList: MutableList<Property> = mutableListOf(),
    val error: String = ""
)