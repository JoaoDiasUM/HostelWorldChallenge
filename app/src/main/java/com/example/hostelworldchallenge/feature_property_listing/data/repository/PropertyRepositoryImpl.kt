package com.example.hostelworldchallenge.feature_property_listing.data.repository

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.Rates
import com.example.hostelworldchallenge.feature_property_listing.data.remote.PropertyApiService
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyApiService: PropertyApiService
) : PropertyRepository {
    override suspend fun getProperties(): MutableList<Property> {
        val response = propertyApiService.getProperties()

        return if (response.isSuccessful) {
            val properties = response.body()
            if (properties != null) {
                return properties.properties
            } else {
               mutableListOf()
            }
        } else {
            mutableListOf()
        }
    }

    override suspend fun getRates(): Rates? {
        val response = propertyApiService.getRates()

        return if (response.isSuccessful) {
            val rates = response.body()
            if (rates != null) {
                return rates.rates
            } else {
               null
            }
        } else {
            return null
        }
    }
}