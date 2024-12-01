package com.example.hostelworldchallenge.feature_property_listing.domain.repository

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.PropertyRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.RatesRequestResponse

interface PropertyRepository {
    suspend fun getProperties(): PropertyRequestResponse?
    suspend fun getRates(): RatesRequestResponse?
    suspend fun getStats(action: String, duration: Long): Long
}