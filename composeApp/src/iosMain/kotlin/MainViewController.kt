import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.platform.AccessibilityDebugLogger
import androidx.compose.ui.platform.AccessibilitySyncOptions
import androidx.compose.ui.window.ComposeUIViewController

@OptIn(ExperimentalComposeApi::class)
fun MainViewController() = ComposeUIViewController(
    content = {
        App()
    },
    configure = {
        accessibilitySyncOptions = AccessibilitySyncOptions.Always(null)
    }
)