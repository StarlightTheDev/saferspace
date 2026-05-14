package com.example.saferspace.ui.venueList

import com.example.saferspace.model.Venue
import com.example.saferspace.ui.venueDetails.VenueDetailsState

data class VenueListState(
    val venueList: List<Venue> = listOf(
        VenueDetailsState().venue,
        VenueDetailsState().venue,
        VenueDetailsState().venue,
        VenueDetailsState().venue),
)
