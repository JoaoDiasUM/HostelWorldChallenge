package com.example.hostelworldchallenge.fakes

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.PropertyRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.RatesRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository

class FakePropertyRepository: PropertyRepository {
    override suspend fun getProperties(): PropertyRequestResponse {
        return FakeProperty.fakePropertyRequestResponse
    }

    override suspend fun getRates(): RatesRequestResponse {
        return FakeRates.fakeRate
    }

    override suspend fun getStats(action: String, duration: Long): Long {
        return 100
    }
}