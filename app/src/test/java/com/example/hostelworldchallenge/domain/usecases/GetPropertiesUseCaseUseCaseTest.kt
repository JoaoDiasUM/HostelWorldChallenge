package com.example.hostelworldchallenge.domain.usecases

import app.cash.turbine.test
import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.fakes.FakeProperty
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetPropertiesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetPropertiesUseCaseUseCaseTest {
    private lateinit var sut: GetPropertiesUseCase
    private lateinit var propertyRepository: PropertyRepository

    @Before
    fun setup() {
        propertyRepository = mockk()
        sut = GetPropertiesUseCase(propertyRepository)
    }

    @Test
    fun `Get property list success`() = runTest {
        val result = sut.invoke()

        val propertyRequestResponse = FakeProperty.fakePropertyRequestResponse

        val mappedResponse = FakeProperty.mappedFakePropertyRequestResponse

        coEvery {
            propertyRepository.getProperties()
        } returns propertyRequestResponse

        result.test {
            val expected = awaitItem()
            assert(expected is Resource.Success)
            assertEquals(mappedResponse, (expected as Resource.Success).data)
            awaitComplete()
        }
    }
}