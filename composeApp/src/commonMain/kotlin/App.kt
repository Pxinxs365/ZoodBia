import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.example.zoodbia.ui.main.MainViewModel
import org.example.zoodbia.di.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        // KoinContext {    // TODO: need?
        // TODO: will be used to populate data from
        val viewModel = koinViewModel<MainViewModel>()
        val uiState = viewModel.uiState.collectAsState().value

        WelcomeScreen()
        
        Navigation()
        // }
    }
}
