package com.example.hostelworldchallenge.feature_property_listing.data.model.property

data class Pagination(
    val next: String,
    val numberOfPages: Int,
    val prev: String,
    val totalNumberOfItems: Int
)