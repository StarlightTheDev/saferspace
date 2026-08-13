package com.example.saferspace.ui.venueDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saferspace.repository.VenueRepo
import com.example.saferspace.ui.navigation.NavigationPath
import com.example.saferspace.ui.navigation.Navigator
import com.example.saferspace.ui.venueList.VenueListIntent
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
