package com.example.nutriritmo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalendarEditScreen(onBack: () -> Unit) {

    val dias = listOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")

    Column(Modifier.padding(16.dp)) {

        Text("Editar calendario", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        dias.forEach { dia ->

            var ayuno by remember { mutableStateOf(false) }
            var ejercicio by remember { mutableStateOf(false) }
            var comida by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(Modifier.padding(16.dp)) {

                    Text(dia, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Ayuno")
                        Switch(checked = ayuno, onCheckedChange = { ayuno = it })
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Entrenamiento")
                        Switch(checked = ejercicio, onCheckedChange = { ejercicio = it })
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Comida mexicana")
                        Switch(checked = comida, onCheckedChange = { comida = it })
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar cambios")
        }
    }
}
