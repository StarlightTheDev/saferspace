package com.example.saferspace.ui.venueDetails

import kotlinx.datetime.LocalDate

data class VenueDetailsState(
    val name: String = "Masken",
    val policy: String? = "No rascism\n No homophobia",
    val reviews: List<Review> = listOf(
        Review(LocalDate(2026, 5, 5), "Keysmash"),
        Review(LocalDate(2026, 5, 6), "foobar")
    ),
)
