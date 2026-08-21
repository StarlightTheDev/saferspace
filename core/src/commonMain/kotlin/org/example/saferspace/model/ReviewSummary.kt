package org.example.saferspace.model

import kotlinx.serialization.Serializable

@Serializable
data class ReviewSummary(
    val option1: Double,
    val option2: Double,
    val option3: Double,
    val option4: Double,
    val option5: Double,
)
