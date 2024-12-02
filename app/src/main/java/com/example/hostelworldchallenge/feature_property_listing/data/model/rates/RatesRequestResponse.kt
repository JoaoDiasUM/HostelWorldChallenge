package com.example.hostelworldchallenge.feature_property_listing.data.model.rates

import com.example.hostelworldchallenge.feature_property_listing.domain.model.RatesEntity

data class RatesRequestResponse(
    val base: String,
    val date: String,
    val historical: Boolean,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int,
    var responseTime: Long? = 0
)  {
    fun toRatesResponseEntity(): RatesEntity {
        return RatesEntity(
            euro = rates.euro,
            dollar = rates.dollar,
            pound = rates.pound,
            responseTime = responseTime
        )
    }
}