package org.example.saferspace

import org.example.saferspace.model.ReviewSummary
import org.example.saferspace.model.Venue
import org.example.saferspace.model.Review
import kotlinx.coroutines.flow.flowOf
import kotlinx.datetime.LocalDate

class VenueRepo {
    val venues = listOf(
            Venue(
                id = 1,
                name = "MASKEN BAR OG CAFÉ",
                latitude = 55.67816,
                longitude = 12.56862,
                pictureUrl = "",
                logoUrl = "https://maskenbar.dk/wp-content/uploads/2026/06/cropped-Masken-logo-fritlagt-med-spejlbillede-589874-scaled-1.png",
                address = "Studiestraede 33, 1455 Koebenhavn K",
                policy = "Politikker",
                phoneNumber = "Intet tlf.nr.",
                reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                reviews = listOf(
                    Review(LocalDate(2026, 5, 5), "Keysmash"),
                    Review(LocalDate(2026, 5, 6), "foobar")
                ),
            ),
            Venue(
                id = 2,
                name = "GBAR Aarhus",
                latitude = 56.15507,
                longitude = 10.21157,
                pictureUrl = "",
                logoUrl = "https://lgbthusaarhus.dk/wp-content/uploads/2025/05/275909730_662038188246113_7023323973649166540_n.png",
                address = "Skolegade 28, 8000 Aarhus C",
                policy = "Politikker",
                phoneNumber = "Intet tlf.nr.",
                reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                reviews = listOf(
                    Review(LocalDate(2026, 5, 5), "Keysmash"),
                    Review(LocalDate(2026, 5, 6), "foobar")
                ),
            ),
            Venue(
                id = 3,
                name = "OSCAR BAR OG CAFÉ",
                latitude = 55.67573,
                longitude = 12.57163,
                pictureUrl = "",
                logoUrl = "https://usercontent.one/wp/www.oscarbarcafe.dk/wp-content/uploads/2024/06/OscarWeblogo350x100px.png",
                address = "Regnbuepladsen 9, 1550 Koebenhavn V",
                policy = "Politikker",
                phoneNumber = "+45 33 12 09 99",
                reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                reviews = listOf(
                    Review(LocalDate(2026, 5, 5), "Keysmash"),
                    Review(LocalDate(2026, 5, 6), "foobar")
                ),
            ),
        )
        fun findAll() = venues
        fun findById(id: Int) = venues.find { it.id == id }
    }