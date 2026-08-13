package com.example.saferspace.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.saferspace.ui.venueDetails.VenueDetailsScreen
import com.example.saferspace.ui.venueDetails.VenueDetailsState
import com.example.saferspace.ui.venueDetails.VenueDetailsViewModel
import com.example.saferspace.ui.venueList.VenueListScreen
import com.example.saferspace.ui.venueList.VenueListState
import com.example.saferspace.ui.venueList.VenueListViewModel
import com.example.saferspace.ui.venueMap.VenueMapScreen
import com.example.saferspace.ui.venueMap.VenueMapViewModel
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(ExperimentalSerializationApi::class)
// Specify subclasses for the navigation framework when not running JVM (no reflection)
private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
           subclassesOfSealed<NavigationPath>()
        }
    }
}
@OptIn(KoinExperimentalAPI::class)
@Composable
fun Navigation(navigator: Navigator = koinInject()) {
    val backStack = rememberNavBackStack(config, NavigationPath.VenueMap)

    NavDisplay(
        backStack,
        onBack = navigator::navigateBack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        // Maps NavigationPath to Composables
        entryProvider = koinEntryProvider<NavKey>()
    )

    LaunchedEffect(Unit) {
        navigator.backStack = backStack
    }
}