package org.example.saferspace.ui.venueList

sealed interface VenueListIntent {
    data object NavigateToMap : VenueListIntent
    data class NavigateToDetails(val venueId: Int) : VenueListIntent
}