package com.example.hostelworldchallenge.domain.usecases

import app.cash.turbine.test
import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.fakes.FakeRates
import com.example.hostelworldchallenge.feature_property_listing.domain.model.RatesEntity
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetRatesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetRatesUseCaseTest {
    private lateinit var sut: GetRatesUseCase
    private lateinit var propertyRepository: PropertyRepository

    @Before
    fun setup() {
        propertyRepository = mockk()
        sut = GetRatesUseCase(propertyRepository)
    }

    @Test
    fun `Get rates success`() = runTest {
        val result = sut.invoke()

        val rates = FakeRates.fakeRate

        val fakeRatesEntity = RatesEntity(1,1.1,1.1,100)

        coEvery {
            propertyRepository.getRates()
        } returns rates

        result.test {
            val expected = awaitItem()
            assert(expected is Resource.Success)
            Assert.assertEquals(fakeRatesEntity, (expected as Resource.Success).data)
            awaitComplete()
        }
    }
}