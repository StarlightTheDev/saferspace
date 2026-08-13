package org.example.saferspace.ui.venueMap

sealed interface VenueMapIntent{

    data class NavigateToDetails(val venueId: Int) : VenueMapIntent
    data object NavigateToList : VenueMapIntent
}