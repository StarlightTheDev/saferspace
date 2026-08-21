package org.example.saferspace.ui.venueMap

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
import org.example.saferspace.ui.venueList.VenueListState
import org.maplibre.spatialk.geojson.Feature
import org.maplibre.spatialk.geojson.FeatureCollection
import org.maplibre.spatialk.geojson.Point
import org.maplibre.spatialk.geojson.Position

class VenueMapViewModel(
    venueRepo: VenueRepo,
    val navigator: Navigator
): ViewModel() {
    val state = MutableStateFlow(VenueMapState(FeatureCollection(emptyList())))
    init {
        viewModelScope.launch {
            val venues = venueRepo.findAll()
            val features = venues.map { venuePointInfo ->
                Feature(
                    geometry = Point(
                        coordinates = Position(
                            longitude = venuePointInfo.longitude,
                            latitude = venuePointInfo.latitude
                        )
                    ),
                    VenuePointProperties(id = venuePointInfo.id, label = venuePointInfo.name)
                )
            }
            state.update {
                VenueMapState(FeatureCollection(features))
            }
        }
    }
    fun onIntent(intent: VenueMapIntent) {
        when (intent) {
            is VenueMapIntent.NavigateToDetails -> navigator.navigate(NavigationPath.VenueDetails(intent.venueId))
            VenueMapIntent.NavigateToList -> navigator.navigate(NavigationPath.VenueList)
        }
    }
}
