package com.example.hostelworldchallenge.feature_property_listing.data.model.rates

data class RatesRequestResponse(
    val base: String,
    val date: String,
    val historical: Boolean,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int,
    var responseTime: Long? = 0
)