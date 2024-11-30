package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hostelworldchallenge.R
import com.example.hostelworldchallenge.common.Constants
import com.example.hostelworldchallenge.feature_property_listing.data.model.Property
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.PropertyImage
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PropertyListingItemScreen(
    property: Property,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        Column {

            val pagerState = rememberPagerState { property.imagesGallery.size }

            val imageUrlList = mutableListOf<String>()

            repeat(property.imagesGallery.size) {
                val prefix = property.imagesGallery[it].prefix
                val suffix = property.imagesGallery[it].suffix
                imageUrlList.add(Constants.HTTP_PREFIX + "$prefix$suffix")
            }

            HorizontalPager(
                state = pagerState
            ) { page ->
                PropertyImage(imageUrlList[page])
            }

            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = property.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Row {
                Icon(
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 0.dp, 0.dp),
                    painter = painterResource(id = R.drawable.ic_rating),
                    tint = Color.Unspecified,
                    contentDescription = "Rating Icon"
                )

                val propertyRating = String.format(
                    Locale.getDefault(),
                    "%.1f",
                    property.overallRating.overall / 10.0
                )

                Text(
                    modifier = Modifier
                        .padding(4.dp, 10.dp, 0.dp, 0.dp),
                    text = propertyRating,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Row {
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
                    text = property.lowestPricePerNight.value + stringResource(id = R.string.euro_sign),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        if (property.isFeatured) {
            Text(
                text = stringResource(id = R.string.featured_title),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorResource(id = R.color.purple_500))
                    .align(Alignment.TopEnd)
                    .padding(2.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}