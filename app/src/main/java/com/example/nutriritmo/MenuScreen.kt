package com.example.nutriritmo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(onBack: () -> Unit) {

    var showRecipe by remember { mutableStateOf(false) }
    var selectedMeal by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            "Tu menú del día 🍽️",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))

        MealCard(
            title = "Desayuno",
            icon = "🍳",
            meal = "Huevos a la mexicana",
            onClick = {
                selectedMeal = "Huevos a la mexicana"
                showRecipe = true
            }
        )

        Spacer(Modifier.height(12.dp))

        MealCard(
            title = "Comida",
            icon = "🌮",
            meal = "Tacos de pollo",
            onClick = {
                selectedMeal = "Tacos de pollo"
                showRecipe = true
            }
        )

        Spacer(Modifier.height(12.dp))

        MealCard(
            title = "Cena",
            icon = "🥗",
            meal = "Ensalada ligera",
            onClick = {
                selectedMeal = "Ensalada ligera"
                showRecipe = true
            }
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }

    if (showRecipe) {
        AlertDialog(
            onDismissRequest = { showRecipe = false },
            title = { Text("Receta completa") },
            text = {
                Text(
                    when (selectedMeal) {
                        "Huevos a la mexicana" ->
                            "Huevos, tomate, cebolla, chile, sal, aceite y tortillas."
                        "Tacos de pollo" ->
                            "Pollo, tortillas, cebolla, cilantro, limón y salsa."
                        "Ensalada ligera" ->
                            "Lechuga, jitomate, pepino, aceite de oliva y limón."
                        else -> ""
                    }
                )
            },
            confirmButton = {
                TextButton(onClick = { showRecipe = false }) {
                    Text("Cerrar")
                }
            }
        )
    }
}

@Composable
fun MealCard(
    title: String,
    icon: String,
    meal: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text("$icon  $title", fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(8.dp))

            Text(meal)

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver receta completa")
            }
        }
    }
}
