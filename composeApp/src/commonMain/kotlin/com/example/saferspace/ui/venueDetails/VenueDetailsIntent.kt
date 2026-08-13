package com.example.saferspace.ui.venueDetails

sealed interface VenueDetailsIntent {
    data object Return : VenueDetailsIntent
}