package com.example.saferspace.model

import com.example.saferspace.ui.venueDetails.Review
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

data class Venue(
    val id: Int,
    val name: String,
    val pictureUrl: String,
    val logoUrl: String,
    val address: String,
    val policy: String?,
    val phoneNumber: String,
    val reviewSummary: ReviewSummary,
    val reviews: List<Review>,
    val latitude: Double,
    val longitude: Double,
    )
    {

}