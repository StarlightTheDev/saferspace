package com.example.saferspace.ui.venueMap

import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.saferspace.ui.navigation.NavigationPath
import org.maplibre.compose.map.MaplibreMap

@Composable
fun VenueMapScreen(navigateTo: (NavigationPath) -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateTo(NavigationPath.VenueList) }
            ) {
                Text(text = "List")
            }
        },
        floatingActionButtonPosition = FabPosition.Start,
    ) {
        MaplibreMap()
    }
}