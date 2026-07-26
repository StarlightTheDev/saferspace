package com.example.saferspace.ui.venueMap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.maplibre.spatialk.geojson.Feature
import org.maplibre.spatialk.geojson.FeatureCollection
import org.maplibre.spatialk.geojson.Point
import org.maplibre.spatialk.geojson.Position

class VenueMapViewModel(
    venueRepo: VenueRepo = VenueRepo()
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
                    VenuePointProperties(label = venuePointInfo.name)
                )
            }))
            // Convert Flow to StateFlow
        }.stateIn(
            viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = VenueMapState()
        )

    fun onIntent(intent: VenueMapIntent) {
        // When-block for intents (MVI pattern)
    }
}
