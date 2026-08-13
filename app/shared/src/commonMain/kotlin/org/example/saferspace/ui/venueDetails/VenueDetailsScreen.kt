package org.example.saferspace.ui.venueDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.example.saferspace.model.ReviewSummary
import org.example.saferspace.model.Venue
import kotlinx.datetime.LocalDate
import org.example.saferspace.model.Review
import org.jetbrains.compose.resources.painterResource
import saferspace.app.shared.generated.resources.Res
import saferspace.app.shared.generated.resources.arrow_back

@Preview(showBackground = true)
@Composable
fun VenueDetailsScreenPreview() {
    MaterialTheme {
        VenueDetailsScreen(
            VenueDetailsState(
                Venue(
                    id = 1,
                    name = "MASKEN BAR OG CAFÉ",
                    latitude = 55.67816,
                    longitude = 12.56862,
                    pictureUrl = "",
                    logoUrl = "https://maskenbar.dk/wp-content/uploads/2026/06/cropped-Masken-logo-fritlagt-med-spejlbillede-589874-scaled-1.png",
                    address = "Studiestraede 33, 1455 Koebenhavn K",
                    policy = "Politikker",
                    phoneNumber = "Intet tlf.nr.",
                    reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                    reviews = listOf(
                        Review(LocalDate(2026, 5, 5), "Keysmash"),
                        Review(LocalDate(2026, 5, 6), "foobar")
                    ),
                )
            )
        ) {}
    }
}

@Composable
fun VenueDetailsScreen(state: VenueDetailsState, onIntent: (VenueDetailsIntent) -> Unit) {
    if (state.venue == null) return
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        Arrangement.spacedBy(16.dp)
    ) {
        IconButton(
            onClick = {
                onIntent(VenueDetailsIntent.Return)
            }
        ) {
            Icon(painterResource(Res.drawable.arrow_back), contentDescription = null)
        }
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
        Text(
            text = state.venue.address + "\n" + state.venue.phoneNumber,
            style = MaterialTheme.typography.bodyMedium,
        )
        Card(Modifier.fillMaxWidth()) {
            Text(
                text = "SaferSpace Policy:",
                style = MaterialTheme.typography.headlineMedium,
            )
            if (state.venue.policy != null) {
                Text(
                    text = state.venue.policy!!,
                )
            } else {
                Text(
                    text = "No policy",
                )
            }
        }
        Text(
            text = state.venue.reviewSummary.toString(),
            style = MaterialTheme.typography.bodyMedium,
        )
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