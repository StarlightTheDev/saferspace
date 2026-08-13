package com.example.saferspace.repository

import com.example.saferspace.model.ReviewSummary
import com.example.saferspace.model.Venue
import com.example.saferspace.ui.venueDetails.Review
import kotlinx.coroutines.flow.flowOf
import kotlinx.datetime.LocalDate

class VenueRepo {
        private val venues = listOf(
            Venue(
                id = 1,
                name = "Masken Bar",
                latitude = 55.67816,
                longitude = 12.56862,
                pictureUrl = "",
                logoUrl = "https://maskenbar.dk/wp-content/uploads/2023/07/masken-logo-fritlagt.png",
                address = "Adressefelt",
                policy = "Politikker",
                phoneNumber = "TLF. Nr.",
                reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                reviews = listOf(
                    Review(LocalDate(2026, 5, 5), "Keysmash"),
                    Review(LocalDate(2026, 5, 6), "foobar")
                ),
            ),
            Venue(
                id = 2,
                name = "GBAR",
                latitude = 56.15507,
                longitude = 10.21157,
                pictureUrl = "",
                logoUrl = "",
                address = "Adressefelt",
                policy = "Politikker",
                phoneNumber = "TLF. Nr.",
                reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                reviews = listOf(
                    Review(LocalDate(2026, 5, 5), "Keysmash"),
                    Review(LocalDate(2026, 5, 6), "foobar")
                ),
            ),
            Venue(
                id = 3,
                name = "Oscar Bar Cafe",
                latitude = 55.67573,
                longitude = 12.57163,
                pictureUrl = "",
                logoUrl = "",
                address = "Adressefelt",
                policy = "Politikker",
                phoneNumber = "TLF. Nr.",
                reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                reviews = listOf(
                    Review(LocalDate(2026, 5, 5), "Keysmash"),
                    Review(LocalDate(2026, 5, 6), "foobar")
                ),
            ),
        )
        fun findAll() = flowOf(venues)
        fun findById(id: Int) = flowOf(venues.find { it.id == id })
    }