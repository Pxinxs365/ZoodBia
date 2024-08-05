import androidx.compose.ui.window.ComposeUIViewController
import org.example.zoodbia.di.KoinInitializer
import org.example.zoodbia.navigation.navcontroller.AppNavController

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
        // add logging for ios
//        NapierProxyKt.debugBuild()
    }
) {
    AppNavController()
}
