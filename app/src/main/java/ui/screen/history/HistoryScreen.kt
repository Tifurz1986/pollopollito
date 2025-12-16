package com.example.pollopollito.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.pollopollito.ThawApp
import com.example.pollopollito.data.local.ThawEntity
import kotlinx.coroutines.flow.collectLatest
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistoryScreen() {
    val context = LocalContext.current
    val container = (context.applicationContext as ThawApp).container

    var itemsList by remember { mutableStateOf<List<ThawEntity>>(emptyList()) }

    LaunchedEffect(Unit) {
        container.thawRepository.observeAll().collectLatest {
            itemsList = it
        }
    }

    val formatter = remember {
        SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Histórico") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(itemsList) { item ->
                ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(item.chickenType.label, style = MaterialTheme.typography.titleMedium)
                        Text("Bolsas: ${item.bolsas}")
                        Text("Usuario: ${item.initials}")
                        Text("Hora: ${formatter.format(Date(item.createdAtMillis))}")
                    }
                }
            }
        }
    }
}
