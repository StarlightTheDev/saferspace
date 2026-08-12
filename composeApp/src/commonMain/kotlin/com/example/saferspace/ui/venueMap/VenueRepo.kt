package com.example.saferspace.ui.venueMap

import kotlinx.coroutines.flow.flowOf

class VenueRepo {
        private val venues = listOf(
            VenuePointInfo(
                id = 1,
                name = "Masken Bar",
                latitude = 55.67816,
                longitude = 12.56862,
            ),
            VenuePointInfo(
                id = 2,
                name = "GBAR",
                latitude = 56.15507,
                longitude = 10.21157,
            ),
            VenuePointInfo(
                id = 3,
                name = "Oscar Bar Cafe",
                latitude = 55.67573,
                longitude = 12.57163,
            ),
        )
        fun findAll() = flowOf(venues)
    }

