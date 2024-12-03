package com.example.hostelworldchallenge.presentation

import com.example.hostelworldchallenge.CoroutineTestRule
import com.example.hostelworldchallenge.common.Resource
import com.example.hostelworldchallenge.fakes.FakeProperty
import com.example.hostelworldchallenge.fakes.FakeRates
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetPropertiesUseCase
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetRatesUseCase
import com.example.hostelworldchallenge.feature_property_listing.domain.usecase.GetStatsUseCase
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing.PropertyViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class PropertyViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val getPropertiesUseCase: GetPropertiesUseCase =
        mockk<GetPropertiesUseCase>(relaxed = true)
    private var getRatesUseCase: GetRatesUseCase = mockk<GetRatesUseCase>(relaxed = true)
    private var getStatsUseCase: GetStatsUseCase = mockk<GetStatsUseCase>(relaxed = true)

    @get:Rule
    val rule = CoroutineTestRule(testDispatcher)

    private lateinit var viewmodel: PropertyViewModel

    @Before
    fun setup() {
        viewmodel = PropertyViewModel(
            getPropertiesUseCase = getPropertiesUseCase,
            getRatesUseCase = getRatesUseCase,
            getStatsUseCase = getStatsUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getProperties Success`() = runTest {
        val fakeResponse = FakeProperty.mappedFakePropertyRequestResponse

        coEvery { getPropertiesUseCase() } returns flowOf(Resource.Success(fakeResponse))
        coEvery { getStatsUseCase(any(), any()) } returns flowOf(Resource.Success(100))

        viewmodel.getProperties()

        with(viewmodel.state.value) {
            assertFalse(isLoading)
            assertEquals(fakeResponse.properties, propertyList)
            error?.isEmpty()?.let { assertTrue(it) }
        }

        coVerify { getStatsUseCase("load-details", 100) }
    }

    @Test
    fun `getProperties Error`() = runTest {

        coEvery { getPropertiesUseCase() } returns flowOf(Resource.Error("No properties found"))

        viewmodel.getProperties()

        with(viewmodel.state.value) {
            assertFalse(isLoading)
            assertEquals("No properties found", error)
        }
    }

    @Test
    fun `getRates Success`() = runTest {
        val fakeResponse = FakeRates.fakeRatesEntity

        coEvery { getRatesUseCase() } returns flowOf(Resource.Success(fakeResponse))
        coEvery { getStatsUseCase(any(), any()) } returns flowOf(Resource.Success(100))

        viewmodel.getRates()

        with(viewmodel.state.value) {
            assertFalse(isLoading)
            assertEquals(fakeResponse, rates)
            error?.isEmpty()?.let { assertTrue(it) }
        }

        coVerify { getStatsUseCase("load-rates", 100) }
    }

    @Test
    fun `getRates Error`() = runTest {

        coEvery { getRatesUseCase() } returns flowOf(Resource.Error("No rates found"))

        viewmodel.getRates()

        with(viewmodel.state.value) {
            assertFalse(isLoading)
            assertEquals("No rates found", error)
        }
    }
}