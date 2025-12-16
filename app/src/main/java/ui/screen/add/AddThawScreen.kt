package ui.screen.add

import androidx.compose.runtime.Composable
import com.example.pollopollito.di.AppContainer

/**
 * Legacy wrapper kept temporarily so old source paths compile.
 * Delegates to the real screen in com.example.pollopollito.ui.screens.add
 */
@Deprecated(
    message = "Legacy wrapper. Use com.example.pollopollito.ui.screens.add.AddThawScreen instead.",
    replaceWith = ReplaceWith(
        expression = "com.example.pollopollito.ui.screens.add.AddThawScreen(container, onDone)"
    )
)
@Composable
fun AddThawScreen(
    container: AppContainer,
    onDone: () -> Unit
) {
    com.example.pollopollito.ui.screens.add.AddThawScreen(
        container = container,
        onDone = onDone
    )
}
