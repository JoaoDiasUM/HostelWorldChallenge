package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property

@Composable
fun PropertyImage(imageUrl: String, size: Int) {
    // Have an improved placeholder image in case the request is slow, or image was not found
    // Open large version of image on click
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(size.dp)
            .clip(RoundedCornerShape(24.dp)),
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Image from URL",
        contentScale = ContentScale.Crop,
    )
}