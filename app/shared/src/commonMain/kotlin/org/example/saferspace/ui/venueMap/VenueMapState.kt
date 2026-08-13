package org.example.saferspace.ui.venueMap

import org.maplibre.spatialk.geojson.FeatureCollection
import org.maplibre.spatialk.geojson.Point

data class VenueMapState(
    // Collection of points on the map (geojson)
    val featureCollection: FeatureCollection<Point, VenuePointProperties> = FeatureCollection()
)