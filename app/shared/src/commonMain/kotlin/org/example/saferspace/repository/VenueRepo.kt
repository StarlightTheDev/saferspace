package org.example.saferspace.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import org.example.saferspace.model.Venue

private const val ANDROID_EMULATOR = "10.0.2.2"
private const val LAN = "192.168.1.94" //hostname -I for Linux, network settings for Mac

class VenueRepo {
    val client = HttpClient() {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url("http://$LAN:8080/")
        }
    }

        suspend fun findAll() = client.get("venues").body<List<Venue>>()
        suspend fun findById(id: Int) = client.get("venues/$id").body<Venue>()
    }