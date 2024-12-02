package com.example.hostelworldchallenge.feature_property_listing.domain.usecase

import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.feature_property_listing.domain.model.RatesEntity
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRatesUseCase @Inject constructor(
    private val propertiesRepository: PropertyRepository
) {
    operator fun invoke(): Flow<Resource<RatesEntity>> = flow {
        try {
            val rates = propertiesRepository.getRates()

            if (rates != null) {
                emit(Resource.Success(rates.toRatesResponseEntity()))
            } else {
                emit(Resource.Error("Something went wrong"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error happened"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An server error error happened"))
        }
    }
}