package org.example.saferspace.ui.venueMap

import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.em
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.painterResource
import org.maplibre.compose.expressions.dsl.asString
import org.maplibre.compose.expressions.dsl.feature
import org.maplibre.compose.expressions.dsl.format
import org.maplibre.compose.expressions.dsl.image
import org.maplibre.compose.expressions.dsl.offset
import org.maplibre.compose.expressions.dsl.span
import org.maplibre.compose.layers.SymbolLayer
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.sources.GeoJsonData
import org.maplibre.compose.sources.rememberGeoJsonSource
import org.maplibre.compose.util.ClickResult
import org.maplibre.spatialk.geojson.toJson
import saferspace.app.shared.generated.resources.Res
import saferspace.app.shared.generated.resources.marker

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
/*        MaplibreMap(
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

 */
    }
}