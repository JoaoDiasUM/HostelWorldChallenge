package com.example.hostelworldchallenge.fakes

import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Distance
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.District
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.FabSort
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.FreeCancellation
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Image
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestAverageDormPricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestAveragePricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestAveragePrivatePricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestDormPricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestPricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.LowestPrivatePricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.OriginalLowestAverageDormPricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.OriginalLowestAveragePricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.OriginalLowestAveragePrivatePricePerNight
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.OverallRating
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Promotions
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.Property
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.PropertyRequestResponse
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.RatingBreakdown
import com.example.hostelworldchallenge.feature_property_listing.domain.model.PropertyEntity
import com.example.hostelworldchallenge.feature_property_listing.domain.model.PropertyRequestResponseEntity

object FakeProperty {
    private val distance = Distance("", 0.0)

    private val district = District("", "")

    private val fabSort = FabSort(1, 1, 1, 1, 1, 1, 1, 1, 1)

    private val freeCancellation = FreeCancellation("", "")

    private val lowestPricePerNight = LowestPricePerNight("", "")

    private val lowestDormPricePerNight = LowestDormPricePerNight("", "")

    private val lowestPrivatePricePerNight = LowestPrivatePricePerNight("", "")

    private val lowestAveragePricePerNight =
        LowestAveragePricePerNight("", "", Promotions(emptyList(), ""), "")

    private val lowestAverageDormPricePerNight =
        LowestAverageDormPricePerNight("", "", Promotions(emptyList(), ""), "")

    private val lowestAveragePrivatePricePerNight =
        LowestAveragePrivatePricePerNight("", "", Promotions(emptyList(), ""), "")

    private val originalLowestAveragePrivatePricePerNight =
        OriginalLowestAveragePrivatePricePerNight("", "")

    private val originalLowestAveragePricePerNight = OriginalLowestAveragePricePerNight("", "")

    private val originalLowestAverageDormPricePerNight =
        OriginalLowestAverageDormPricePerNight("", "")

    private val overallRating = OverallRating("", 0)

    private val ratingBreakdown = RatingBreakdown(0, 0, 0, 0, 0, 0, 0, 0, 0)

    val fakeProperty = Property(
        "",
        "",
        distance,
        district,
        emptyList(),
        fabSort,
        emptyList(),
        0,
        freeCancellation,
        false,
        "",
        0,
        false,
        1,
        0,
        emptyList(),
        emptyList(),
        false,
        false,
        false,
        false,
        1.0,
        1.0,
        lowestAverageDormPricePerNight,
        lowestAveragePricePerNight,
        lowestAveragePrivatePricePerNight,
        lowestDormPricePerNight,
        lowestPricePerNight,
        lowestPrivatePricePerNight,
        "",
        originalLowestAverageDormPricePerNight,
        originalLowestAveragePricePerNight,
        originalLowestAveragePrivatePricePerNight,
        overallRating,
        "",
        0,
        emptyList(),
        emptyList(),
        ratingBreakdown,
        1,
        emptyList(),
        "",
        false
    )
    val fakePropertyEntity = PropertyEntity(
        1,
        "",
        "",
        freeCancellation,
        false,
        "",
        emptyList(),
        false,
        lowestPricePerNight,
        lowestAveragePricePerNight,
        "",
        overallRating,
        "",
        1,
        "",
        emptyList(),
        0.0,
        0.0
    )

    val fakePropertyRequestResponse = PropertyRequestResponse(
        mutableListOf(fakeProperty, fakeProperty), 100
    )

    val mappedFakePropertyRequestResponse = PropertyRequestResponseEntity(
        mutableListOf(fakeProperty.toPropertyEntity(), fakeProperty.toPropertyEntity()), 100
    )
}