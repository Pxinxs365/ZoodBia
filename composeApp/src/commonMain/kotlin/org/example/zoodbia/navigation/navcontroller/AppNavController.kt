package org.example.zoodbia.navigation.navcontroller

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.zoodbia.navigation.AppNavigation
import org.example.zoodbia.navigation.MainNavigation

@Composable
internal fun AppNavController() {
    val navigator = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navigator,
            startDestination = AppNavigation.Auth.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(route = AppNavigation.Auth.route) {
                AuthNavController(navigateToMain = {
                    navigator.popBackStack()
                    navigator.navigate(AppNavigation.Main.route)
                })
            }

            composable(route = AppNavigation.Main.route) {
                MainNavController()
            }
        }
    }
}