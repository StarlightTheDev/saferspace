package com.example.saferspace

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform