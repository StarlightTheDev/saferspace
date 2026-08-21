package org.example.saferspace.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val date: LocalDate,
    val text: String,
)
