package com.example.hostelworldchallenge.feature_property_listing.domain.usecase

import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStatsUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(action: String, duration: Long): Flow<Resource<Long>> = flow {
        try {
            val stats = propertyRepository.getStats(action,duration)

            emit(Resource.Success(stats))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error happened"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An server error error happened"))
        }
    }
}