package org.example.saferspace.ui.venueList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import org.example.saferspace.repository.VenueRepo
import org.example.saferspace.ui.navigation.NavigationPath
import org.example.saferspace.ui.navigation.Navigator
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.saferspace.ui.venueDetails.VenueDetailsState

class VenueListViewModel(
    venueRepo: VenueRepo,
    val navigator: Navigator
): ViewModel() {
    val state = MutableStateFlow(VenueListState(emptyList()))
    init {
        viewModelScope.launch {
            state.update {
                VenueListState(venueRepo.findAll())
            }
        }
    }
    fun onIntent(intent: VenueListIntent) {
        when (intent) {
            is VenueListIntent.NavigateToDetails ->
                navigator.navigate(NavigationPath.VenueDetails(intent.venueId))

            VenueListIntent.NavigateToMap -> navigator.navigate(NavigationPath.VenueMap)
        }
    }
}
