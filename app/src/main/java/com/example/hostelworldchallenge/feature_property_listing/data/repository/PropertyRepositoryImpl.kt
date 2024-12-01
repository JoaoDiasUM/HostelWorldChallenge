package com.example.hostelworldchallenge.feature_property_listing.data.repository

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.PropertyRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.RatesRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.remote.PropertyApiService
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyApiService: PropertyApiService
) : PropertyRepository {
    override suspend fun getProperties(): PropertyRequestResponse? {
        val response = propertyApiService.getProperties()

        val receiveTime = response.raw().receivedResponseAtMillis
        val sendTime = response.raw().sentRequestAtMillis
        val requestTime = receiveTime - sendTime

        return if (response.isSuccessful) {
            val properties = response.body()
            if (properties != null) {
                properties.responseTime = requestTime
                return properties
            } else {
                null
            }
        } else {
           null
        }
    }

    override suspend fun getRates(): RatesRequestResponse? {
        val response = propertyApiService.getRates()

        val receiveTime = response.raw().receivedResponseAtMillis
        val sendTime = response.raw().sentRequestAtMillis
        val requestTime = receiveTime - sendTime

        return if (response.isSuccessful) {
            val rates = response.body()
            if (rates != null) {
                rates.responseTime = requestTime
                return rates
            } else {
                null
            }
        } else {
            return null
        }
    }

    override suspend fun getStats(action: String, duration: Long): Long {
        val response = propertyApiService.getStats(action, duration)

        return if (response.isSuccessful) {
            val stats = response.body()
            if (stats != null) {
                return stats
            } else {
                0
            }
        } else {
            0
        }
    }
}