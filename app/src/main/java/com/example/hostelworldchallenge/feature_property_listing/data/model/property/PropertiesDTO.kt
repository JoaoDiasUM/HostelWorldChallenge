package com.example.hostelworldchallenge.feature_property_listing.data.model.property

data class PropertiesDTO(
    val filterData: FilterData,
    val location: Location,
    val locationEn: LocationEn,
    val pagination: Pagination,
    val properties: List<Property>,
    val sortOrder: Any
)