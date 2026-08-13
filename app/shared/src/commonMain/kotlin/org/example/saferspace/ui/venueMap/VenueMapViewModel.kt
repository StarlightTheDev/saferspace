package org.example.saferspace.ui.venueMap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.example.saferspace.repository.VenueRepo
import org.example.saferspace.ui.navigation.NavigationPath
import org.example.saferspace.ui.navigation.Navigator
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.maplibre.spatialk.geojson.Feature
import org.maplibre.spatialk.geojson.FeatureCollection
import org.maplibre.spatialk.geojson.Point
import org.maplibre.spatialk.geojson.Position

class VenueMapViewModel(
    venueRepo: VenueRepo,
    val navigator: Navigator
): ViewModel() {
    val state = venueRepo.findAll()
        .map { list ->
            VenueMapState(FeatureCollection(features = list.map { venuePointInfo ->
                Feature(
                    geometry = Point(
                        coordinates = Position(
                            longitude = venuePointInfo.longitude,
                            latitude = venuePointInfo.latitude
                        )
                    ),
                    VenuePointProperties(id = venuePointInfo.id, label = venuePointInfo.name)
                )
            }))
            // Convert Flow to StateFlow
        }.stateIn(
            viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = VenueMapState()
        )

    fun onIntent(intent: VenueMapIntent) {
        when (intent) {
            is VenueMapIntent.NavigateToDetails -> navigator.navigate(NavigationPath.VenueDetails(intent.venueId))
            VenueMapIntent.NavigateToList -> navigator.navigate(NavigationPath.VenueList)
        }
    }
}
