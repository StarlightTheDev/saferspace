package com.example.saferspace.ui.venueDetails

import com.example.saferspace.model.Venue
import kotlinx.datetime.LocalDate

data class VenueDetailsState(
    val venue: Venue = Venue(
        "Masken",
        "",
        "https://maskenbar.dk/wp-content/uploads/2023/07/masken-logo-fritlagt.png",
        "Studiestraede 33",
        "No racism\nNo homophobia",
        listOf(
            Review(LocalDate(2026, 5, 5), "Keysmash"),
            Review(LocalDate(2026, 5, 6), "foobar")
        )
    )
)
