package org.example.saferspace.ui.venueDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import org.example.saferspace.repository.VenueRepo
import org.example.saferspace.ui.navigation.Navigator
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VenueDetailsViewModel(
    venueId: Int,
    venueRepo: VenueRepo,
    val navigator: Navigator
): ViewModel() {
    val state = MutableStateFlow<VenueDetailsState>(VenueDetailsState(null))
    init {
        viewModelScope.launch {
            state.update {
                VenueDetailsState(venueRepo.findById(venueId))
            }
        }
    }

    fun onIntent(intent: VenueDetailsIntent) {
        when (intent) {
            is VenueDetailsIntent.Return -> navigator.navigateBack()
        }
    }
}
