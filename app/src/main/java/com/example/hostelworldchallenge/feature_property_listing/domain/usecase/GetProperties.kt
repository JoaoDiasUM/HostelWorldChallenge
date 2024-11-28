package com.example.hostelworldchallenge.feature_property_listing.domain.usecase

import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.feature_property_listing.data.model.Property
import com.example.hostelworldchallenge.feature_property_listing.data.model.PropertyResponse
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProperties @Inject constructor(
    private val propertiesRepository: PropertyRepository
) {
    operator fun invoke(): Flow<Resource<List<Property>>> = flow {
        try {
            val properties = propertiesRepository.getProperties()

            if (properties?.isNotEmpty() == true) {
                emit(Resource.Success(properties))
            } else {
                emit(Resource.Error("No properties found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error happened"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An server error error happened"))
        }
    }
}