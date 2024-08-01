import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.zoodbia.ui.main.LoginScreen
import org.example.zoodbia.ui.main.SignUpScreen
import org.example.zoodbia.ui.main.WelcomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Welcome"){
        composable("Welcome"){
            WelcomeScreen(navController)
        }
        composable("Login"){
            LoginScreen(navController)
        }
        composable("SignUp"){
            SignUpScreen()
        }
    }
    
}