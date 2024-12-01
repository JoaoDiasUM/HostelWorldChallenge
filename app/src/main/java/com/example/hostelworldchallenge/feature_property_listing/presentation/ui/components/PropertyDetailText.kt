package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PropertyDetailText(propertyTitle: String, propertyText: String) {
    Row(
        modifier = Modifier.padding(
            start = 10.dp,
            end = 10.dp,
            top = 5.dp,
        )
    ) {
        Text(
            text = propertyTitle,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        )

        Text(
            text = propertyText,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
    }
}