package com.example.hostelworldchallenge.feature_property_listing.domain.repository

import com.example.hostelworldchallenge.feature_property_listing.data.model.Property

interface PropertyRepository {
    suspend fun getProperties(): List<Property>
}