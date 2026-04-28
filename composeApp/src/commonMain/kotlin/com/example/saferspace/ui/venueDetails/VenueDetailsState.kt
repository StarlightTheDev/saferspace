package com.example.saferspace.ui.venueDetails

data class VenueDetailsState(
    val name: String = "Masken",
    val policy: String? = null,
    val reviews: List<String> = emptyList(),
)
