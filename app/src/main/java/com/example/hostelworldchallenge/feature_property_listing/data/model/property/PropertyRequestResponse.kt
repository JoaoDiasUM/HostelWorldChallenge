package com.example.hostelworldchallenge.feature_property_listing.data.model.property

data class PropertyRequestResponse(
    val properties: MutableList<Property>,
    var responseTime: Long? = 0
)