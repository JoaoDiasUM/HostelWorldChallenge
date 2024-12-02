package com.example.hostelworldchallenge.feature_property_listing.data.model.rates

import com.example.hostelworldchallenge.feature_property_listing.domain.model.RatesEntity
import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("EUR")
    val euro: Int,
    @SerializedName("USD")
    val dollar: Double,
    @SerializedName("GBP")
    val pound: Double,
)  {
    fun toRatesEntity(): RatesEntity {
        return RatesEntity(
            euro = euro,
            dollar = dollar,
            pound = pound
        )
    }
}