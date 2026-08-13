package org.example.saferspace.model

import kotlinx.datetime.LocalDate

data class Review(
    val date: LocalDate,
    val text: String,
)
