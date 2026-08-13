package com.example.saferspace.ui.venueMap

import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.em
import androidx.graphics.shapes.Feature
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.saferspace.ui.navigation.NavigationPath
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.painterResource
import org.maplibre.compose.expressions.dsl.asNumber
import org.maplibre.compose.expressions.dsl.asString
import org.maplibre.compose.expressions.dsl.convertToNumber
import org.maplibre.compose.expressions.dsl.feature
import org.maplibre.compose.expressions.dsl.format
import org.maplibre.compose.expressions.dsl.get
import org.maplibre.compose.expressions.dsl.image
import org.maplibre.compose.expressions.dsl.offset
import org.maplibre.compose.expressions.dsl.span
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.layers.SymbolLayer
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.sources.GeoJsonData
import org.maplibre.compose.sources.rememberGeoJsonSource
import org.maplibre.compose.style.BaseStyle
import org.maplibre.compose.util.ClickResult
import org.maplibre.spatialk.geojson.Geometry
import org.maplibre.spatialk.geojson.Point
import org.maplibre.spatialk.geojson.toJson
import saferspacefrontend.composeapp.generated.resources.Res
import saferspacefrontend.composeapp.generated.resources.marker

private val json = Json { ignoreUnknownKeys = true }

@Composable
fun VenueMapScreen(
    state: VenueMapState,
    onIntent: (VenueMapIntent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onIntent(VenueMapIntent.NavigateToList) }
            ) {
                Text(text = "List")
            }
        },
        floatingActionButtonPosition = FabPosition.Start,
    ) {
        MaplibreMap(
            // If a style is active then the points disappear. Most likely a bug (current version is pre-release)
            //baseStyle = BaseStyle.Uri("https://tiles.openfreemap.org/styles/liberty")
        ) {
            SymbolLayer(
                id = "",
                source = rememberGeoJsonSource(
                    data = GeoJsonData.Features(geoJson = state.featureCollection)
                ),
                iconImage = image(value = painterResource(Res.drawable.marker)),
                textField = format(span(value = feature["label"].asString())),
                textOffset = offset(x = 0.em, y = 0.6.em),
                onClick = { features ->
                    val id = json.decodeFromString<SerializerHelper>(features[0].toJson()).properties.id
                    onIntent(VenueMapIntent.NavigateToDetails(id))
                    ClickResult.Consume
                }
            )
        }
    }
}