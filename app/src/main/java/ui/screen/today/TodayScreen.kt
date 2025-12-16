package com.example.pollopollito.ui.screens.today

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodayScreen(
    onAdd: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Hoy") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onAdd,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
            ) {
                Text("Registrar descongelación")
            }

            Text(
                "MVP v0.1: registro rápido de descongelaciones.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
