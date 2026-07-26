package com.example.saferspace.ui.venueMap

import kotlinx.coroutines.flow.flowOf

class VenueRepo {
        private val venues = listOf(
            VenuePointInfo(
                name = "GBAR",
                latitude = 56.15507,
                longitude = 10.21157,
            ),
            VenuePointInfo(
                name = "Masken Bar",
                latitude = 55.67816,
                longitude = 12.56862,
            ),
            VenuePointInfo(
                name = "Oscar Bar Cafe",
                latitude = 55.67573,
                longitude = 12.57163,
            ),
        )
        fun findAll() = flowOf(venues)
    }

