package org.example.saferspace.model

import kotlinx.serialization.Serializable

@Serializable
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
