package com.example.pollopollito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pollopollito.navigation.AppNavHost
import com.example.pollopollito.ui.theme.PollopollitoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // App-wide dependencies live in the Application class (we'll create it next)
        val container = (application as PollopollitoApp).container

        setContent {
            PollopollitoTheme {
                AppNavHost(container = container)
            }
        }
    }
}