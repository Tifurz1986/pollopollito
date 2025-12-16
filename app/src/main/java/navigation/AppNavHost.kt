package com.example.pollopollito.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.pollopollito.di.AppContainer
import com.example.pollopollito.ui.screens.add.AddThawScreen
import com.example.pollopollito.ui.screens.history.HistoryScreen
import com.example.pollopollito.ui.screens.login.LoginScreen
import com.example.pollopollito.ui.screens.today.TodayScreen
import com.example.pollopollito.ui.widget.BottomBar
import com.example.pollopollito.ui.widget.BottomItem
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun AppNavHost(
    container: AppContainer,
    modifier: Modifier = Modifier
) {
    val rootNav = rememberNavController()
    val scope = rememberCoroutineScope()

    var start by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(Unit) {
        val userId = container.userPrefs.userId.first()
        start = if (userId.isNullOrBlank()) Routes.LOGIN else Routes.MAIN
    }

    if (start == null) return

    NavHost(
        navController = rootNav,
        startDestination = start!!,
        modifier = modifier
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginCr = {
                    scope.launch {
                        container.userPrefs.loginAsCr()
                        rootNav.navigate(Routes.MAIN) {
                            popUpTo(Routes.LOGIN) { inclusive = true }
                        }
                    }
                }
            )
        }

        composable(Routes.MAIN) {
            val mainNav = rememberNavController()

            val items = listOf(
                BottomItem(Routes.TODAY, "Hoy", Icons.Filled.Home),
                BottomItem(Routes.HISTORY, "Histórico", Icons.Filled.Home)
            )

            Scaffold(
                bottomBar = { BottomBar(navController = mainNav, items = items) }
            ) { padding ->
                NavHost(
                    navController = mainNav,
                    startDestination = Routes.TODAY,
                    modifier = Modifier.padding(padding)
                ) {
                    composable(Routes.TODAY) {
                        TodayScreen(onAdd = { mainNav.navigate(Routes.ADD) })
                    }
                    composable(Routes.HISTORY) {
                        HistoryScreen()
                    }
                    composable(Routes.ADD) {
                        AddThawScreen(container = container, onDone = { mainNav.popBackStack() })
                    }
                }
            }
        }
    }
}
