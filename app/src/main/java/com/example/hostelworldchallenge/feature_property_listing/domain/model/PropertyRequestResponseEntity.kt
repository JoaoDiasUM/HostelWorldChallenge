package com.example.hostelworldchallenge.feature_property_listing.domain.model

data class PropertyRequestResponseEntity(
    val properties: MutableList<PropertyEntity>,
    var responseTime: Long? = 0
)
