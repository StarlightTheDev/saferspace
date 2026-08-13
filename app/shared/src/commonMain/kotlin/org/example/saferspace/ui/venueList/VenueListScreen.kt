package org.example.saferspace.ui.venueList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.saferspace.model.ReviewSummary
import org.example.saferspace.model.Venue
import org.example.saferspace.model.Review
import kotlinx.datetime.LocalDate

@Preview
@Composable
fun VenueListScreenPreview() {
    MaterialTheme {
        VenueListScreen(
            VenueListState(
                listOf(
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
                    ),
                    Venue(
                        id = 2,
                        name = "GBAR Aarhus",
                        latitude = 56.15507,
                        longitude = 10.21157,
                        pictureUrl = "",
                        logoUrl = "https://lgbthusaarhus.dk/wp-content/uploads/2025/05/275909730_662038188246113_7023323973649166540_n.png",
                        address = "Skolegade 28, 8000 Aarhus C",
                        policy = "Politikker",
                        phoneNumber = "Intet tlf.nr.",
                        reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                        reviews = listOf(
                            Review(LocalDate(2026, 5, 5), "Keysmash"),
                            Review(LocalDate(2026, 5, 6), "foobar")
                        ),
                    ),
                    Venue(
                        id = 3,
                        name = "OSCAR BAR OG CAFÉ",
                        latitude = 55.67573,
                        longitude = 12.57163,
                        pictureUrl = "",
                        logoUrl = "https://usercontent.one/wp/www.oscarbarcafe.dk/wp-content/uploads/2024/06/OscarWeblogo350x100px.png",
                        address = "Regnbuepladsen 9, 1550 Koebenhavn V",
                        policy = "Politikker",
                        phoneNumber = "+45 33 12 09 99",
                        reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5),
                        reviews = listOf(
                            Review(LocalDate(2026, 5, 5), "Keysmash"),
                            Review(LocalDate(2026, 5, 6), "foobar")
                        ),
                    ),
                )
            )
        ) {}
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun VenueListScreen(state: VenueListState, onIntent: (VenueListIntent) -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onIntent(VenueListIntent.NavigateToMap) }
            ) {
                Text(text = "Map")
            }
        },
        floatingActionButtonPosition = FabPosition.Start,
    ) { paddingValues ->
        Column(
            Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            Text(
                text = "SaferSpace Venues",
                style = MaterialTheme.typography.headlineLarge,
            )
            state.venueList.forEachIndexed { index, venue ->
                SegmentedListItem(
                    onClick = {
                        onIntent(VenueListIntent.NavigateToDetails(venue.id))
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
}