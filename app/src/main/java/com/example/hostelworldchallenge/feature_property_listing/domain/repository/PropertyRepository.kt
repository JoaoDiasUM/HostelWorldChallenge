package com.example.hostelworldchallenge.feature_property_listing.domain.repository

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.Rates

interface PropertyRepository {
    suspend fun getProperties(): MutableList<Property>
    suspend fun getRates(): Rates?
}