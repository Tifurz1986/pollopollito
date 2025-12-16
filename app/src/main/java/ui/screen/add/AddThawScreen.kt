
package ui.screen.add

import androidx.compose.runtime.Composable
import com.example.pollopollito.di.AppContainer

/**
 * Legacy wrapper kept temporarily so old source paths compile.
 * Delegates to the real screen in com.example.pollopollito.ui.screens.add
 */
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

