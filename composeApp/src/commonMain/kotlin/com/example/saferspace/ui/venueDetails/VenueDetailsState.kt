package com.example.saferspace.ui.venueDetails

import kotlinx.datetime.LocalDate

data class VenueDetailsState(
    val name: String = "Masken",
    val pictureUrl: String = "",
    val logoUrl: String = "https://maskenbar.dk/wp-content/uploads/2023/07/masken-logo-fritlagt.png",
    val address: String = "",
    val policy: String? = "No racism\nNo homophobia",
    val reviews: List<Review> = listOf(
        Review(LocalDate(2026, 5, 5), "Keysmash"),
        Review(LocalDate(2026, 5, 6), "foobar")
    ),
)
