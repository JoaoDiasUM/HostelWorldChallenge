package com.example.hostelworldchallenge.feature_property_listing.domain.model

data class RatesEntity(
    val euro: Int,
    val dollar: Double,
    val pound: Double,
    var responseTime: Long? = 0
)