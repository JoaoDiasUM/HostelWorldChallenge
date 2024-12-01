package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListingDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hostelworldchallenge.R
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.CurrencySelector
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.FacilityItem
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.LowestPricePerNight
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.NoConnectionView
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.PropertyDetailText
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.PropertyImagesHorizontalSlider
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing.PropertyViewModel
import org.jsoup.Jsoup

@Composable
fun PropertyListingItemDetailsScreen(
    propertyViewModel: PropertyViewModel,
    selectedPropertyId: String
) {
    val state = propertyViewModel.state.collectAsStateWithLifecycle()

    val selectedProperty = state.value.propertyList.find { it.id.toString() == selectedPropertyId }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.brown))
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .padding(8.dp)
        ) {
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxSize()
            ) {
                if (selectedProperty != null) {
                    Text(
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        text = selectedProperty.name,
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    val currencyOptions: Array<String> =
                        LocalContext.current.resources.getStringArray(R.array.currency_options_array)

                    var selectedRate by remember { mutableStateOf(currencyOptions[0]) }

                    PropertyImagesHorizontalSlider(property = selectedProperty,
                        LocalContext.current.resources.getInteger(R.integer.details_horizontal_slider)
                    )

                    val overview =
                        Jsoup.parse(selectedProperty.overview).text()

                    Text(
                        modifier = Modifier
                            .padding(10.dp,16.dp,10.dp,10.dp),
                        text = overview,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    LowestPricePerNight(
                        property = selectedProperty,
                        selectedRate,
                        state.value.rates
                    )

                    PropertyDetailText(stringResource(id = R.string.property_title_type), propertyText = selectedProperty.type)

                    PropertyDetailText(
                        stringResource(id = R.string.property_title_address),
                        propertyText = selectedProperty.address1 + ", " + selectedProperty.address2
                    )

                    if (selectedProperty.freeCancellationAvailable) {
                        PropertyDetailText(
                            stringResource(id = R.string.property_title_free_cancellation_until),
                            propertyText = selectedProperty.freeCancellationAvailableUntil
                        )
                    }


                    if (selectedProperty.facilities.isNotEmpty()) {
                        selectedProperty.facilities.forEach {
                            if (selectedProperty.facilities.isNotEmpty()) {
                                it.facilities.forEach { facility ->
                                    FacilityItem(facilityX = facility)
                                }
                            }
                        }
                    }


                    CurrencySelector(
                        rates = currencyOptions,
                        selectedRate = selectedRate,
                        onRateSelected = { selectedRate = it }
                    )
                } else {
                    NoConnectionView()
                }
            }
        }
    }
}