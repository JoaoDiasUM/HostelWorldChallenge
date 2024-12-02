package com.example.hostelworldchallenge.feature_property_listing.data.model.property

import com.example.hostelworldchallenge.feature_property_listing.domain.model.PropertyEntity
import com.example.hostelworldchallenge.feature_property_listing.domain.model.PropertyRequestResponseEntity

data class PropertyRequestResponse(
    val properties: MutableList<Property>,
    var responseTime: Long? = 0
) {
    fun mapToPropertyRequestEntity(): PropertyRequestResponseEntity {

        val properties = mutableListOf<PropertyEntity>()

        this.properties.forEach {
            properties.add(it.toPropertyEntity())
        }

        return PropertyRequestResponseEntity(
            properties = properties,
            responseTime = responseTime
        )
    }
}