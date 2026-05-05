package com.example.saferspace.ui.venueDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
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
            style = MaterialTheme.typography.headlineLarge,
        )
        if (state.policy != null) {
            Text(
                text = state.policy,
            )
        } else {
            Text(
                text = "No policy",
            )
        }
        state.reviews.forEach { review ->
            ListItem(
                headlineContent = { Text(text = review.text) },
                overlineContent = { Text(text = "${review.date}") }
            )
        }
    }
}