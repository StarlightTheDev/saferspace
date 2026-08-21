package org.example.saferspace

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.util.getValue
import org.example.saferspace.VenueTable.address
import org.example.saferspace.VenueTable.latitude
import org.example.saferspace.VenueTable.logoUrl
import org.example.saferspace.VenueTable.longitude
import org.example.saferspace.VenueTable.name
import org.example.saferspace.VenueTable.phoneNumber
import org.example.saferspace.VenueTable.pictureUrl
import org.example.saferspace.VenueTable.policy
import org.example.saferspace.model.ReviewSummary
import org.example.saferspace.model.Venue
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    val db = Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver", user = "root") //Lazy connection

    transaction(db) {
        SchemaUtils.create(VenueTable)

        VenueRepo().venues.forEach { venue ->
            VenueTable.insert {
                it[phoneNumber] = venue.phoneNumber
                it[latitude] = venue.latitude
                it[longitude] = venue.longitude
                it[address] = venue.address
                it[policy] = venue.policy ?: ""
                it[name] = venue.name
                it[pictureUrl] = venue.pictureUrl
                it[logoUrl] = venue.logoUrl
            }
        }
    }
    routing {
        get("/venues") {
            val venues = transaction(db) {
                VenueTable.selectAll().toList().map {
                    Venue(
                        id = it[VenueTable.id],
                        phoneNumber = it[phoneNumber],
                        latitude = it[latitude],
                        longitude = it[longitude],
                        address = it[address],
                        policy = it[policy],
                        name = it[name],
                        pictureUrl = it[pictureUrl],
                        logoUrl = it[logoUrl],
                        reviews = emptyList(),
                        reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5)
                    )
                }
            }
            call.respond(venues)
        }
        get("/venues/{id}") {
            val id: Int by call.parameters
            val venue = transaction(db) {
                VenueTable.selectAll()
                    .where(VenueTable.id eq id).map {
                        Venue(
                            id = it[VenueTable.id],
                            phoneNumber = it[phoneNumber],
                            latitude = it[latitude],
                            longitude = it[longitude],
                            address = it[address],
                            policy = it[policy],
                            name = it[name],
                            pictureUrl = it[pictureUrl],
                            logoUrl = it[logoUrl],
                            reviews = emptyList(),
                            reviewSummary = ReviewSummary(0.1, 0.2, 0.3, 0.4, 0.5)
                        )
                    }.singleOrNull()
            }
            if (venue == null) call.respond(HttpStatusCode.NotFound)
            else call.respond(venue)
        }
    }
}