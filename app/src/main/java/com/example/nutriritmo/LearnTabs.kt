package com.example.nutriritmo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun LearnTabs() {

    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Beneficios", "Tipos", "Tips", "Mitos")

    Column {

        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        when (tabIndex) {
            0 -> Text("• Reduce inflamación\n• Mejora energía\n• Salud metabólica")
            1 -> Text("• 16/8\n• 18/6\n• 20/4 (OMAD)")
            2 -> Text("• No exageres\n• Hidratación\n• Rompe ayuno bien")
            3 -> Text("• No destruye músculo\n• No es una dieta extrema\n• No es para todos")
        }
    }
}
