package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hostelworldchallenge.R
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property
import com.example.hostelworldchallenge.feature_property_listing.data.model.rates.Rates
import java.util.Locale

@Composable
fun LowestPricePerNight(property: Property, selectedRate: String? = null, rates: Rates? = null) {
    Row {
        var lowestPrice =
            property.lowestPricePerNight.value + stringResource(id = R.string.euro_sign)

        if(rates != null && selectedRate != null) {
            when (selectedRate) {
                "EUR" -> {
                    val lowestPriceInEuro = property.lowestPricePerNight.value.toDouble().times(rates.euro)
                    val lowestPrinceInEuroFormatted = String.format(Locale.getDefault(),"%.2f", lowestPriceInEuro)
                    lowestPrice = lowestPrinceInEuroFormatted + stringResource(id = R.string.euro_sign)
                }

                "GBP" -> {
                    val lowestPriceInPounds = property.lowestPricePerNight.value.toDouble().times(rates.pound)
                    val lowestPrinceInPoundsFormatted = String.format(Locale.getDefault(),"%.2f", lowestPriceInPounds)
                    lowestPrice = lowestPrinceInPoundsFormatted + stringResource(id = R.string.pound_sign)
                }

                "USD" -> {
                    val lowestPriceInDollar = property.lowestPricePerNight.value.toDouble().times(rates.dollar)
                    val lowestPrinceInDollarFormatted = String.format(Locale.getDefault(),"%.2f", lowestPriceInDollar)
                    lowestPrice = lowestPrinceInDollarFormatted + stringResource(id = R.string.dollar_sign)
                }
            }
        }

        Text(
            modifier = Modifier
                .padding(10.dp, 10.dp, 0.dp, 0.dp),
            text = stringResource(id = R.string.lowest_price_title),
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        )

        Text(
            modifier = Modifier
                .padding(4.dp, 10.dp, 0.dp, 0.dp),
            text = lowestPrice,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
    }
}