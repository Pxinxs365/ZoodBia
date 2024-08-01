package org.example.zoodbia.navigation

import androidx.navigation.NamedNavArgument

sealed class SplashNavigation(val route: String, val arguments: List<NamedNavArgument>) {
    
    data object Welcome: SplashNavigation(route = "Welcome", arguments = emptyList())
    
    data object Login: SplashNavigation(route = "Login", arguments = emptyList())
    
    data object SignUp: SplashNavigation(route = "SignUp", arguments = emptyList())
}