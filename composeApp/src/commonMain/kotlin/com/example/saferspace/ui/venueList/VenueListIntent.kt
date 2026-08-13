package com.example.saferspace.ui.venueList

import com.example.saferspace.model.Venue

sealed interface VenueListIntent {
    data object NavigateToMap : VenueListIntent
    data class NavigateToDetails(val venueId: Int) : VenueListIntent
}