package com.example.nutriritmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriRitmoTheme {
                var showSplash by remember { mutableStateOf(true) }

                if (showSplash) {
                    SplashScreen(onFinish = { showSplash = false })
                } else {
                    NutriRitmoApp()
                }
            }
        }
    }
}

@Composable
fun NutriRitmoApp() {
    var isLoggedIn by remember { mutableStateOf(false) }
    val navController = rememberNavController()

    if (!isLoggedIn) {
        // Navegación de autenticación (Welcome / Login / Register)
        AuthNavHost(
            navController = navController,
            onAuthSuccess = { isLoggedIn = true }
        )
    } else {
        // Navegación principal con BottomBar (Calendario, Ayuno, etc.)
        RootScreen()
    }
}
