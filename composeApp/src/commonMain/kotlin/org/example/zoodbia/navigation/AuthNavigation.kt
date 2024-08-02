package org.example.zoodbia.navigation

import androidx.navigation.NamedNavArgument

sealed class AuthNavigation(val route: String, val arguments: List<NamedNavArgument>) {
    
    data object Welcome: AuthNavigation(route = "Welcome", arguments = emptyList())
    
    data object Login: AuthNavigation(route = "Login", arguments = emptyList())
    
    data object SignUp: AuthNavigation(route = "SignUp", arguments = emptyList())
}