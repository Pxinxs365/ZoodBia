package org.example.zoodbia.navigation.navcontroller

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.zoodbia.navigation.AuthNavigation
import org.example.zoodbia.ui.main.LoginScreen
import org.example.zoodbia.ui.main.SignUpScreen
import org.example.zoodbia.ui.main.WelcomeScreen

@Composable
internal fun AuthNavController() {
    val navigator = rememberNavController()
    
    NavHost(
        startDestination = AuthNavigation.Welcome.route,
        navController = navigator,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = AuthNavigation.Welcome.route){
            WelcomeScreen(navigateToLogin = {
                navigator.navigate(AuthNavigation.Login.route)
            })
        }
        composable(route = AuthNavigation.Login.route){
            LoginScreen(navigateToSignUp = {
                navigator.navigate(AuthNavigation.SignUp.route)
            })
        }
        composable(route = AuthNavigation.SignUp.route){
            SignUpScreen(popUp = {
                navigator.popBackStack()
            })
        }
    }
}