package org.example.saferspace.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationPath : NavKey {
    @Serializable
    data object VenueList : NavigationPath

    @Serializable
    data object VenueMap : NavigationPath

    @Serializable
    data class VenueDetails(val venueId: Int) : NavigationPath
}