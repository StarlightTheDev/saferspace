package com.example.saferspace.ui.venueDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun VenueDetailsScreenPreview() {
    VenueDetailsScreen(VenueDetailsState())
}

@Composable
fun VenueDetailsScreen(state: VenueDetailsState) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = state.name,
        )
    }
}