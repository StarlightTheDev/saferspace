package org.example.saferspace.ui.venueList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.example.saferspace.repository.VenueRepo
import org.example.saferspace.ui.navigation.NavigationPath
import org.example.saferspace.ui.navigation.Navigator
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class VenueListViewModel(
    venueRepo: VenueRepo,
    val navigator: Navigator
): ViewModel() {
    val state = venueRepo.findAll()
        .map { VenueListState(it) }
        .stateIn(
            viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = VenueListState(emptyList())
        )

    fun onIntent(intent: VenueListIntent) {
        when (intent) {
            is VenueListIntent.NavigateToDetails ->
                navigator.navigate(NavigationPath.VenueDetails(intent.venueId))

            VenueListIntent.NavigateToMap -> navigator.navigate(NavigationPath.VenueMap)
        }
    }
}
