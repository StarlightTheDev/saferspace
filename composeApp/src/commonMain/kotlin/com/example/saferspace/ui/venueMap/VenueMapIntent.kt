package com.example.saferspace.ui.venueMap

import com.example.saferspace.model.Venue
import com.example.saferspace.ui.venueList.VenueListIntent

sealed interface VenueMapIntent{

    data class NavigateToDetails(val venueId: Int) : VenueMapIntent
    data object NavigateToList : VenueMapIntent
}