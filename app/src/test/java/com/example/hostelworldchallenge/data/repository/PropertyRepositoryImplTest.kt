package com.example.hostelworldchallenge.data.repository

import com.example.hostelworldchallenge.fakes.ERROR_RESPONSE
import com.example.hostelworldchallenge.fakes.FakeProperty
import com.example.hostelworldchallenge.fakes.FakeRates
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.PropertyRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.RatesRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.remote.PropertyApiService
import com.example.hostelworldchallenge.feature_property_listing.data.repository.PropertyRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class PropertyRepositoryImplTest {

    private lateinit var sut: PropertyRepositoryImpl
    private val propertyApiService = mockk<PropertyApiService>()
    private val property = FakeProperty.fakePropertyRequestResponse
    private val rates = FakeRates.fakeRate
    private val errorResponseBody =
        ERROR_RESPONSE.toResponseBody("application/json".toMediaTypeOrNull())

    @Before
    fun setup() {
        sut = PropertyRepositoryImpl(propertyApiService)
    }

    @Test
    fun `When user retrieves properties, returns properties list`() = runTest {
        val response = Response.success(property)
        coEvery {
            propertyApiService.getProperties()
        }.returns(response)

        val result = sut.getProperties()
        assert(result != null)
    }

    @Test
    fun `When user retrieves properties, returns nothing`() = runTest {
        val mockResponse = Response.error<PropertyRequestResponse>(400, errorResponseBody)
        coEvery {
            propertyApiService.getProperties()
        }.returns(mockResponse)

        val result = sut.getProperties()
        assert(result == null)
    }

    @Test
    fun `When user retrieves rates, returns current rates`() = runTest {
        val response = Response.success(rates)
        coEvery {
            propertyApiService.getRates()
        }.returns(response)

        val result = sut.getRates()
        assert(result != null)
    }

    @Test
    fun `When user retrieves rates, returns nothing`() = runTest {
        val mockResponse = Response.error<RatesRequestResponse>(400, errorResponseBody)
        coEvery {
            propertyApiService.getRates()
        }.returns(mockResponse)

        val result = sut.getRates()
        assert(result == null)
    }

    @Test
    fun `When user retrieves stats, returns stats value`() = runTest {
        val response = Response.success(1000L)
        coEvery {
            propertyApiService.getStats(any(),any())
        }.returns(response)

        val result = sut.getStats("test",1000L)
        assert(result == 1000L)
    }
}