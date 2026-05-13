package com.example.saferspace.model

import com.example.saferspace.ui.venueDetails.Review
import kotlinx.datetime.LocalDate

data class Venue(
    val name: String,
    val pictureUrl: String,
    val logoUrl: String,
    val address: String,
    val policy: String?,
    val reviews: List<Review>,
)
    {

}