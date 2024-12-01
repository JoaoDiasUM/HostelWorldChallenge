package com.example.hostelworldchallenge.feature_property_listing.presentation

sealed class Screen(val route: String) {
    data object PropertyListingScreen : Screen("property_listing_screen")

    data object PropertyListingDetailsScreen : Screen("property_listing_details_screen/{selectedPropertyId}")
}