package com.example.nutriritmo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(
    val route: String,
    val label: String,
    val emoji: String
)

@Composable
fun RootScreen() {
    val nav = rememberNavController()

    val items = listOf(
        BottomNavItem("calendar_main", "Calendario", "📅"),
        BottomNavItem("fasting", "Ayuno", "⏱️"),
        BottomNavItem("progress", "Progreso", "📈"),
        BottomNavItem("menu", "Menú", "🍽️")
    )

    val navBackStackEntry by nav.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                nav.navigate(item.route) {
                                    launchSingleTop = true
                                }
                            }
                        },
                        icon = { Text(item.emoji) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = nav,
            startDestination = "calendar_main",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("calendar_main") {
                CalendarScreen(
                    onEditClick = { nav.navigate("calendar_edit") }
                )
            }

            composable("calendar_edit") {
                CalendarEditScreen(
                    onBack = { nav.popBackStack() }
                )
            }

            composable("fasting") {
                FastingScreen(
                    onBack = { nav.popBackStack() }
                )
            }

            composable("progress") {
                ProgressScreen(
                    onBack = { nav.popBackStack() }
                )
            }

            composable("menu") {
                MenuScreen(
                    onBack = { nav.popBackStack() }
                )
            }

            composable("extras") {
                ExtrasScreen(
                    onBack = { nav.popBackStack() }
                )
            }
        }
    }
}
