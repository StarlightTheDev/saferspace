package com.example.saferspace.ui.navigation

import com.example.saferspace.model.Venue

sealed interface NavigationPath {
    data object VenueList : NavigationPath

    data object VenueMap : NavigationPath
    data class VenueDetails(val venue: Venue) : NavigationPath
}