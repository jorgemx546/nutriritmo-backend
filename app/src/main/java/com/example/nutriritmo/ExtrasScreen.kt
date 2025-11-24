package com.example.nutriritmo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ExtrasScreen(onBack: () -> Unit) {

    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Metas", "Frases", "Notificaciones")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            "Metas, frases y notificaciones",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        when (tabIndex) {
            0 -> GoalsContent()
            1 -> PhrasesContent()
            2 -> NotificationsContent()
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

@Composable
fun GoalsContent() {
    var objetivo by remember { mutableStateOf("Bajar grasa") }
    var semanas by remember { mutableStateOf("8") }
    var actividad by remember { mutableStateOf("Moderada") }

    val objetivos = listOf("Bajar grasa", "Mantener peso", "Subir masa muscular")
    val niveles = listOf("Baja", "Moderada", "Alta")

    Column {
        Text("Metas personales", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))

        Text("Objetivo principal")
        Spacer(Modifier.height(4.dp))
        var expandedObj by remember { mutableStateOf(false) }
        Box {
            OutlinedButton(onClick = { expandedObj = true }, modifier = Modifier.fillMaxWidth()) {
                Text(objetivo)
            }
            DropdownMenu(expanded = expandedObj, onDismissRequest = { expandedObj = false }) {
                objetivos.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            objetivo = it
                            expandedObj = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = semanas,
            onValueChange = { semanas = it },
            label = { Text("Duración del plan (semanas)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Text("Nivel de actividad física")
        Spacer(Modifier.height(4.dp))
        var expandedNivel by remember { mutableStateOf(false) }
        Box {
            OutlinedButton(onClick = { expandedNivel = true }, modifier = Modifier.fillMaxWidth()) {
                Text(actividad)
            }
            DropdownMenu(expanded = expandedNivel, onDismissRequest = { expandedNivel = false }) {
                niveles.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            actividad = it
                            expandedNivel = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { /* aquí podrías guardar en BD luego */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar metas")
        }
    }
}

@Composable
fun PhrasesContent() {
    val frases = listOf(
        "Un día a la vez.",
        "Tu salud es tu mejor inversión.",
        "La constancia supera a la intensidad.",
        "Pequeños cambios, grandes resultados.",
        "Hoy también cuenta.",
        "Estás más cerca que ayer."
    )

    var fraseActual by remember { mutableStateOf(frases.random()) }

    Column {
        Text("Frase motivacional", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Text(fraseActual)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { fraseActual = frases.random() }, modifier = Modifier.fillMaxWidth()) {
            Text("Ver otra frase")
        }
    }
}

@Composable
fun NotificationsContent() {
    var inicioAyuno by remember { mutableStateOf(true) }
    var finAyuno by remember { mutableStateOf(false) }
    var entrenamiento by remember { mutableStateOf(true) }

    Column {
        Text("Notificaciones", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Inicio de ayuno")
            Switch(checked = inicioAyuno, onCheckedChange = { inicioAyuno = it })
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Hora de romper ayuno")
            Switch(checked = finAyuno, onCheckedChange = { finAyuno = it })
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Entrenamiento programado")
            Switch(checked = entrenamiento, onCheckedChange = { entrenamiento = it })
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { /* guardar config después */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar cambios")
        }
    }
}
