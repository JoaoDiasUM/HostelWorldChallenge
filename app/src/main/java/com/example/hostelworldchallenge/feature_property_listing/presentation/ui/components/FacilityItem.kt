package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hostelworldchallenge.R
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.FacilityX

@Composable
fun FacilityItem(facilityX: FacilityX) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(colorResource(id = R.color.brown))
    ) {
        Text(
            modifier = Modifier.padding(6.dp),
            text = facilityX.name,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }
}