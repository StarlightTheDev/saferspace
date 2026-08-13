package org.example.saferspace.ui.venueDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.example.saferspace.repository.VenueRepo
import org.example.saferspace.ui.navigation.NavigationPath
import org.example.saferspace.ui.navigation.Navigator
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class VenueDetailsViewModel(
    venueId: NavigationPath.VenueDetails,
    venueRepo: VenueRepo,
    val navigator: Navigator
): ViewModel() {
    val state = venueRepo.findById(venueId.venueId)
        .map { VenueDetailsState(it) }
        .stateIn(
            viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = VenueDetailsState(null)
        )

    fun onIntent(intent: VenueDetailsIntent) {
        when (intent) {
            is VenueDetailsIntent.Return -> navigator.navigateBack()
        }
    }
}
