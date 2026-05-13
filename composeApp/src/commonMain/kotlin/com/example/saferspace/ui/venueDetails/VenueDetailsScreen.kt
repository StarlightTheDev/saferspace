package com.example.saferspace.ui.venueDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Preview(showBackground = true)
@Composable
fun VenueDetailsScreenPreview() {
    MaterialTheme {
        VenueDetailsScreen(VenueDetailsState())
    }
}

@Composable
fun VenueDetailsScreen(state: VenueDetailsState) {
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        Arrangement.spacedBy(16.dp)
    ) {
        Row {
            AsyncImage(
                model = state.venue.logoUrl,
                contentDescription = "Logo for ${state.venue.logoUrl}",
                modifier = Modifier.size(64.dp),
            )
            Text(
                text = state.venue.name,
                style = MaterialTheme.typography.headlineLarge,
            )
        }
        Card(Modifier.fillMaxWidth()) {
            Text(
                text = "SaferSpace Policy:",
                style = MaterialTheme.typography.headlineMedium,
            )
            if (state.venue.policy != null) {
                Text(
                    text = state.venue.policy,
                )
            } else {
                Text(
                    text = "No policy",
                )
            }
        }
        Text(
            text = "Reviews:",
            style = MaterialTheme.typography.headlineMedium,
        )
        state.venue.reviews.forEach { review ->
            ListItem(
                headlineContent = { Text(text = review.text) },
                overlineContent = { Text(text = "${review.date}") }
            )
        }
    }
}