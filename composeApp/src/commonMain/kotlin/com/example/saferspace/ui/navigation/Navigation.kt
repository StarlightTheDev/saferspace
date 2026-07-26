package com.example.saferspace.ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.saferspace.ui.venueDetails.VenueDetailsScreen
import com.example.saferspace.ui.venueDetails.VenueDetailsState
import com.example.saferspace.ui.venueList.VenueListScreen
import com.example.saferspace.ui.venueList.VenueListState
import com.example.saferspace.ui.venueMap.VenueMapScreen
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@OptIn(ExperimentalSerializationApi::class)
// Specify subclasses for the navigation framework when not running JVM (no reflection)
private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
           subclassesOfSealed<NavigationPath>()
        }
    }
}
@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(config, NavigationPath.VenueMap)

    NavDisplay(
        backStack,
        // Maps NavigationPath to Composables
        entryProvider = entryProvider {
            entry<NavigationPath.VenueMap> {
                VenueMapScreen(
                    navigateTo = { path -> backStack.add(path) },
                )
            }

            entry<NavigationPath.VenueList> {
                VenueListScreen(
                    state = VenueListState(),
                    navigateTo = { path -> backStack.add(path) },
                )
            }

            entry<NavigationPath.VenueDetails> {
                VenueDetailsScreen(
                    state = VenueDetailsState(),
                    navigateTo = { path -> backStack.add(path) },
                )
            }
        }
    )
}