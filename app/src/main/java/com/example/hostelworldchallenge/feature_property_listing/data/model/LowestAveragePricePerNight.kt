package com.example.hostelworldchallenge.feature_property_listing.data.model

data class LowestAveragePricePerNight(
    val currency: String,
    val original: String,
    val promotions: Promotions,
    val value: String
)