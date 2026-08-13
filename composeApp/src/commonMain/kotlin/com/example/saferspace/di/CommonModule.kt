package com.example.saferspace.di

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.saferspace.repository.VenueRepo
import com.example.saferspace.ui.navigation.NavigationPath
import com.example.saferspace.ui.navigation.Navigator
import com.example.saferspace.ui.venueDetails.VenueDetailsScreen
import com.example.saferspace.ui.venueDetails.VenueDetailsViewModel
import com.example.saferspace.ui.venueList.VenueListScreen
import com.example.saferspace.ui.venueList.VenueListViewModel
import com.example.saferspace.ui.venueMap.VenueMapScreen
import com.example.saferspace.ui.venueMap.VenueMapViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel

@OptIn(KoinExperimentalAPI::class)
val commonModule = module {
    single<VenueRepo>()
    viewModel<VenueMapViewModel>()
    viewModel<VenueListViewModel>()
    viewModel { VenueDetailsViewModel(get(), get(), get()) }

    single<Navigator>()

    navigation<NavigationPath.VenueMap> {
        val viewModel = koinViewModel<VenueMapViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        VenueMapScreen(state, viewModel::onIntent)
    }

    navigation<NavigationPath.VenueList> {
        val viewModel = koinViewModel<VenueListViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        VenueListScreen(state, viewModel::onIntent)
    }

    navigation<NavigationPath.VenueDetails> { route ->
        val viewModel = koinViewModel<VenueDetailsViewModel> { parametersOf(route) }
        val state by viewModel.state.collectAsStateWithLifecycle()
        VenueDetailsScreen(state, viewModel::onIntent)
    }
}