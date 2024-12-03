package com.example.hostelworldchallenge.domain.usecases

import app.cash.turbine.test
import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetRatesUseCase
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetStatsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetStatsUseCaseTest {
    private lateinit var sut: GetStatsUseCase
    private lateinit var propertyRepository: PropertyRepository

    @Before
    fun setup() {
        propertyRepository = mockk()
        sut = GetStatsUseCase(propertyRepository)
    }

    @Test
    fun `Get stats success`() = runTest {
        val result = sut.invoke("",100L)

        coEvery { propertyRepository.getStats(any(),any()) } returns 100L
        result.test {
            val expected = awaitItem()
            assert(expected is Resource.Success)
            Assert.assertEquals(100L, (expected as Resource.Success).data)
            awaitComplete()
        }
    }
}