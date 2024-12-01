package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.Rates

data class PropertyListingViewState(
    val isLoading: Boolean = false,
    val propertyList: MutableList<Property> = mutableListOf(),
    val rates: Rates? = null,
    val error: String = ""
)