package com.example.saferspace.ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.saferspace.ui.venueDetails.VenueDetailsScreen
import com.example.saferspace.ui.venueDetails.VenueDetailsState
import com.example.saferspace.ui.venueList.VenueListScreen
import com.example.saferspace.ui.venueList.VenueListState

@Composable
fun Navigation() {
    var path by remember { mutableStateOf<NavigationPath>(NavigationPath.VenueList) }
    val navigateTo = { p: NavigationPath ->
        path = p
    }
    AnimatedContent(path) {
        when (it) {
            NavigationPath.VenueList -> VenueListScreen(VenueListState(), navigateTo)
            is NavigationPath.VenueDetails -> VenueDetailsScreen(VenueDetailsState(it.venue), navigateTo)
        }
    }
}