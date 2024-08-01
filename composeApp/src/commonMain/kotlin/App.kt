import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.zoodbia.navigation.AppNavigation
import org.example.zoodbia.navigation.SplashNav
import org.example.zoodbia.ui.main.MainViewModel
import org.example.zoodbia.di.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        // KoinContext {    // TODO: need?
        // TODO: will be used to populate data from
        val viewModel = koinViewModel<MainViewModel>()
        val uiState = viewModel.uiState.collectAsState().value
        // }

        val navigator = rememberNavController()

        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navigator,
                startDestination = AppNavigation.Splash.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = AppNavigation.Splash.route) {
                    SplashNav()
                }
            }
        }
    }
}
