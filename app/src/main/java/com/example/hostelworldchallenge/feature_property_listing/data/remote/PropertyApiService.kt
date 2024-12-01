package com.example.hostelworldchallenge.feature_property_listing.data.remote

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.PropertyResponse
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.RatesResponse
import retrofit2.Response
import retrofit2.http.GET

interface PropertyApiService {
    @GET("PedroTrabulo-Hostelworld/a1517b9da90dd6877385a65f324ffbc3/raw/058e83aa802907cb0032a15ca9054da563138541/properties.json")
    suspend fun getProperties(): Response<PropertyResponse>

    @GET("PedroTrabulo-Hostelworld/16e87e40ca7b9650aa8e1b936f23e14e/raw/15efd901b57c2b66bf0201ee7aa9aa2edc6df779/rates.json")
    suspend fun getRates(): Response<RatesResponse>
}