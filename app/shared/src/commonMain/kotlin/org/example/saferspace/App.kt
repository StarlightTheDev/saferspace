package org.example.saferspace

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.example.saferspace.di.commonModule
import org.example.saferspace.ui.navigation.Navigation
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

@Composable
fun App() {
    KoinApplication(configuration = koinConfiguration {
        modules(commonModule)
    }) {
        MaterialTheme {
            Navigation()
        }
    }
}
