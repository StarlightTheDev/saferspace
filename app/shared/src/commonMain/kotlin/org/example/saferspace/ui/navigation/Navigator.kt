package org.example.saferspace.ui.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Navigator {
    var backStack: NavBackStack<NavKey>? = null

    fun navigate(to: NavigationPath){
        backStack?.add(to)
    }

    fun navigateBack(){
        backStack?.removeLastOrNull()
    }
}