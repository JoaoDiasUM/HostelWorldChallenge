package com.example.hostelworldchallenge.feature_property_listing.data.model.rates

data class RatesResponse(
    val base: String,
    val date: String,
    val historical: Boolean,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)