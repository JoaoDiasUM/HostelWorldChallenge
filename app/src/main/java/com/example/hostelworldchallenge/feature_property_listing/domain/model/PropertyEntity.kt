package com.example.hostelworldchallenge.feature_property_listing.domain.model

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Facility
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.FreeCancellation
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.ImagesGallery
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestAveragePricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestPricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.OverallRating

data class PropertyEntity(
    val id: Int,
    val address1: String,
    val address2: String,
    val freeCancellation: FreeCancellation,
    val freeCancellationAvailable: Boolean,
    val freeCancellationAvailableUntil: String,
    val imagesGallery: List<ImagesGallery>,
    val isFeatured: Boolean,
    val lowestPricePerNight: LowestPricePerNight,
    val lowestAveragePricePerNight: LowestAveragePricePerNight,
    val name: String,
    val overallRating: OverallRating,
    val overview: String,
    val starRating: Int,
    val type: String,
    val facilities: List<Facility>,
)
