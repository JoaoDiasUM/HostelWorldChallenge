package com.example.hostelworldchallenge.feature_property_listing.data.repository

import com.example.hostelworldchallenge.feature_property_listing.data.model.Property
import com.example.hostelworldchallenge.feature_property_listing.data.remote.PropertyApiService
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyApiService: PropertyApiService
) : PropertyRepository {
    override suspend fun getProperties(): List<Property> {
        val response = propertyApiService.getProperties()

        return if (response.isSuccessful) {
            val properties = response.body()
            if (properties != null) {
                return properties.properties
            } else {
                emptyList()
            }
        } else {
            emptyList()
        }
    }
}