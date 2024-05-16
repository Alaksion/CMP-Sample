import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.platform.AccessibilityDebugLogger
import androidx.compose.ui.platform.AccessibilitySyncOptions
import androidx.compose.ui.window.ComposeUIViewController

@OptIn(ExperimentalComposeApi::class)
fun MainViewController() = ComposeUIViewController(
    content = { App() },
    configure = {
        this.accessibilitySyncOptions =
            AccessibilitySyncOptions.Always(debugLogger = teste())
    }
)

@OptIn(ExperimentalComposeApi::class)
class teste : AccessibilityDebugLogger {
    override fun log(message: Any?) {

    }

}