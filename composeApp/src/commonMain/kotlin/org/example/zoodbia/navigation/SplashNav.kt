package org.example.zoodbia.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.zoodbia.ui.main.LoginScreen
import org.example.zoodbia.ui.main.SignUpScreen
import org.example.zoodbia.ui.main.WelcomeScreen

@Composable
internal fun SplashNav() {
    val navigator = rememberNavController()
    
    NavHost(
        startDestination = SplashNavigation.Welcome.route,
        navController = navigator,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = SplashNavigation.Welcome.route){
            WelcomeScreen(navigateToLogin = {
                navigator.navigate(SplashNavigation.Login.route)
            })
        }
        composable(route = SplashNavigation.Login.route){
            LoginScreen(navigateToSignUp = {
                navigator.navigate(SplashNavigation.SignUp.route)
            })
        }
        composable(route = SplashNavigation.SignUp.route){
            SignUpScreen(popUp = {
                navigator.popBackStack()
            })
        }
    }
}