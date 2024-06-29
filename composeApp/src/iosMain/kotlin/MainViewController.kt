import androidx.compose.ui.window.ComposeUIViewController
import org.example.zoodbia.di.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    App()
}