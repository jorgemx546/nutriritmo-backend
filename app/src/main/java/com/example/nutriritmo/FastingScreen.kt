package com.example.nutriritmo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FastingScreen(onBack: () -> Unit) {

    // contador — empieza en 8 horas
    var timeLeft by remember { mutableStateOf(8 * 60 * 60) }
    var isRunning by remember { mutableStateOf(false) }

    // mensaje motivacional
    val messages = listOf(
        "¡Tú puedes!",
        "Tu cuerpo te lo va a agradecer",
        "Cada segundo cuenta",
        "Sigue así, vas excelente",
        "La constancia crea resultados",
        "Orgulloso de tu avance"
    )

    var message by remember { mutableStateOf(messages.random()) }

    // modal consejos
    var showTips by remember { mutableStateOf(false) }

    // modal sensaciones
    var showFeel by remember { mutableStateOf(false) }
    var feelingText by remember { mutableStateOf("") }

    // lógica temporizador
    LaunchedEffect(isRunning) {
        while (isRunning && timeLeft > 0) {
            kotlinx.coroutines.delay(1000)
            timeLeft--
        }
    }

    val hours = timeLeft / 3600
    val minutes = (timeLeft % 3600) / 60
    val seconds = timeLeft % 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Ayuno activo", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            String.format("%02d:%02d:%02d", hours, minutes, seconds),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { isRunning = true },
            enabled = !isRunning,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar ayuno")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            message,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { showTips = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver consejos")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { showFeel = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar sensaciones")
        }

        Spacer(modifier = Modifier.height(24.dp))

        LearnTabs()

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar al calendario")
        }
    }

    // Modal CONSEJOS
    if (showTips) {
        AlertDialog(
            onDismissRequest = { showTips = false },
            title = { Text("Consejos para el ayuno") },
            text = {
                Column {
                    Text("• Mantente hidratado")
                    Text("• Evita comida chatarra al romper ayuno")
                    Text("• Descansa lo suficiente")
                    Text("• Camina 10–20 min")
                    Text("• No te compares con otros")
                    Text("• Sé constante, no perfecto")
                }
            },
            confirmButton = {
                TextButton(onClick = { showTips = false }) {
                    Text("Entendido")
                }
            }
        )
    }

    // Modal SENSACIONES
    if (showFeel) {
        AlertDialog(
            onDismissRequest = { showFeel = false },
            title = { Text("Registrar sensaciones") },
            text = {
                OutlinedTextField(
                    value = feelingText,
                    onValueChange = { feelingText = it },
                    label = { Text("¿Cómo te sientes?") },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    showFeel = false
                    feelingText = ""
                }) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showFeel = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
