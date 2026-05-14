package com.example.saferspace.ui.venueList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saferspace.ui.navigation.NavigationPath

@Preview
@Composable
fun VenueListScreenPreview() {
    MaterialTheme {
        VenueListScreen(VenueListState()) {}
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun VenueListScreen(state: VenueListState, navigateTo: (NavigationPath) -> Unit) {
    Column(
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
    ) {
        Text(
            text = "SaferSpace Venues",
            style = MaterialTheme.typography.headlineLarge,
        )
        state.venueList.forEachIndexed { index, venue ->
            SegmentedListItem(
                onClick = {
                    navigateTo(NavigationPath.VenueDetails(venue))
                },
                shapes = ListItemDefaults.segmentedShapes(index, state.venueList.size),
                colors = ListItemDefaults.segmentedColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            ) {
                Text(
                    text = venue.name,
                )
            }
        }
    }
}