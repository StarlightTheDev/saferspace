package com.example.saferspace
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.saferspace.di.commonModule
import com.example.saferspace.ui.navigation.Navigation
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

@Composable
@Preview
fun App() {
    KoinApplication(configuration = koinConfiguration {
        modules(commonModule)
    }) {
        MaterialTheme {
            Navigation()
        }
    }
}