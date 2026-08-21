package org.example.saferspace

import org.example.saferspace.model.Review
import org.example.saferspace.model.ReviewSummary
import org.jetbrains.exposed.v1.core.Table

const val VARCHAR_LENGTH = 255

//Singleton class
object VenueTable : Table("venues") {
    val id = integer(name = "id").autoIncrement()
    val name = varchar("venue_name", VARCHAR_LENGTH)
    val pictureUrl = varchar("picture_url", VARCHAR_LENGTH)
    val logoUrl = varchar("logo_url", VARCHAR_LENGTH)
    val address = varchar("address", VARCHAR_LENGTH)
    val policy = text("policy")
    val phoneNumber = varchar("phone_number", VARCHAR_LENGTH)
    val latitude = double("latitude")
    val longitude = double("longitude")
}