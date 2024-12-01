package com.example.hostelworldchallenge.feature_property_listing.data.model.property

data class Promotion(
    val discount: Int,
    val id: Int,
    val name: String,
    val stack: Boolean,
    val type: String
)