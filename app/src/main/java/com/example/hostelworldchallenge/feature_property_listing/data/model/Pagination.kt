package com.example.hostelworldchallenge.feature_property_listing.data.model

data class Pagination(
    val next: String,
    val numberOfPages: Int,
    val prev: String,
    val totalNumberOfItems: Int
)