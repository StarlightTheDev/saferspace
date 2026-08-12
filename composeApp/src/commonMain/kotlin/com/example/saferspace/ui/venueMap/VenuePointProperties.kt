package com.example.saferspace.ui.venueMap

import kotlinx.serialization.Serializable

@Serializable // Serializing to JSON
data class VenuePointProperties (
    val id: Int,
    val label: String
)