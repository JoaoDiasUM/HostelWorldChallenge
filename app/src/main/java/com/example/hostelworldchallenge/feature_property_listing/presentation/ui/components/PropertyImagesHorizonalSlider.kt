package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.hostelworldchallenge.common.Constants
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PropertyImagesHorizontalSlider(property: Property, size: Int) {
    val pagerState = rememberPagerState { property.imagesGallery.size }

    val imageUrlList = mutableListOf<String>()

    repeat(property.imagesGallery.size) {
        val prefix = property.imagesGallery[it].prefix
        val suffix = property.imagesGallery[it].suffix
        imageUrlList.add("https://$prefix$suffix")
    }

    HorizontalPager(
        state = pagerState
    ) { page ->
        PropertyImage(imageUrlList[page],size)
    }
}