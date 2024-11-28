package com.example.hostelworldchallenge.feature_property_listing.data.remote

import com.example.hostelworldchallenge.feature_property_listing.data.model.PropertyResponse
import retrofit2.Response
import retrofit2.http.GET

interface PropertyApiService {
    @GET("PedroTrabulo-Hostelworld/a1517b9da90dd6877385a65f324ffbc3/raw/058e83aa802907cb0032a15ca9054da563138541/properties.json")
    suspend fun getProperties(): Response<PropertyResponse>
}