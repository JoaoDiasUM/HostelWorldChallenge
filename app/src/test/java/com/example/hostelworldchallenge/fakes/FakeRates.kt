package com.example.hostelworldchallenge.fakes

import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.Rates
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.RatesRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.domain.model.RatesEntity

object FakeRates {
    private val rates = Rates(1, 1.1, 1.1)
    val fakeRate = RatesRequestResponse(
        "", "", false, rates, false, 1, 100
    )

    val fakeRatesEntity = RatesEntity(1,1.0,1.0,100)
}