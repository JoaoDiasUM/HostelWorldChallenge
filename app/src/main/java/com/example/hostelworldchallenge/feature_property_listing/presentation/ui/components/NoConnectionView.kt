package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hostelworldchallenge.R

@Composable
fun NoConnectionView() {
    Text(
        modifier = Modifier
            .padding(20.dp),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.no_connection),
        style = TextStyle(
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    )

    Image(
        painter = painterResource(id = R.drawable.ic_no_connection),
        contentDescription = "Image description",
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp),
        contentScale = ContentScale.Fit
    )
}