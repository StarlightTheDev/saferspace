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
import org.example.saferspace.model.Venue

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        get("/") {
            call.respondText("I too know what a ${Venue::class.simpleName} is!")
        }
        get("/venues") {
            val venues = VenueRepo().findAll()
            call.respond(venues)
        }
        get("/venues/{id}") {
            val id: Int by call.parameters
            val venue = VenueRepo().findById(id)
            if (venue == null) call.respond(HttpStatusCode.NotFound)
            else call.respond(venue)
        }
    }
}