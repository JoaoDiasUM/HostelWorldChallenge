package com.example.hostelworldchallenge.feature_property_listing.data.model.rates

import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("EUR")
    val euro: Int,
    @SerializedName("USD")
    val dollar: Double,
    @SerializedName("GBP")
    val pound: Double,
)