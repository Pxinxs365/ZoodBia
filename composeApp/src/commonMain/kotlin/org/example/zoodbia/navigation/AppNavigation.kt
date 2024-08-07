package org.example.zoodbia.navigation

import androidx.navigation.NamedNavArgument

sealed class AppNavigation(
    val route: String, val arguments: List<NamedNavArgument>
) {
    
    data object Auth: AppNavigation(route = "Auth", arguments = emptyList())

    data object Main: AppNavigation(route = "Main", arguments = emptyList())
}