package com.example.nutriritmo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressScreen(onBack: () -> Unit) {

    var showComparison by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Progreso", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        ProgressCards()

        Spacer(modifier = Modifier.height(24.dp))

        ProgressCharts()

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { showComparison = !showComparison },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (showComparison) "Ocultar comparación" else "Comparar mes anterior")
        }

        if (showComparison) {
            Spacer(modifier = Modifier.height(16.dp))
            ComparisonSection()
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

@Composable
fun ProgressCards() {
    Column(Modifier.fillMaxWidth()) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors()
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Horas de ayuno total", fontWeight = FontWeight.Bold)
                Text("82 hrs", fontSize = 24.sp)
                Text("+12% vs mes anterior")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors()
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Sesiones completadas", fontWeight = FontWeight.Bold)
                Text("14 sesiones", fontSize = 24.sp)
                Text("+3 vs mes anterior")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors()
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Peso perdido", fontWeight = FontWeight.Bold)
                Text("-0.8 kg", fontSize = 24.sp)
                Text("Mejor que el mes anterior")
            }
        }
    }
}

@Composable
fun ProgressCharts() {
    Column(Modifier.fillMaxWidth()) {

        Text("Horas ayuno por semana", fontWeight = FontWeight.Bold)
        FakeBarChart(values = listOf(12f, 14f, 10f, 16f))

        Spacer(modifier = Modifier.height(20.dp))

        Text("Sesiones entrenamiento", fontWeight = FontWeight.Bold)
        FakeBarChart(values = listOf(2f, 3f, 4f, 5f))

        Spacer(modifier = Modifier.height(20.dp))

        Text("Evolución del peso", fontWeight = FontWeight.Bold)
        FakeLineChart(values = listOf(78f, 77.6f, 77.1f, 76.8f))
    }
}

@Composable
fun FakeBarChart(values: List<Float>) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        values.forEach { v ->
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height((v * 4).dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
fun FakeLineChart(values: List<Float>) {
    Text("Gráfica simulada: ${values.joinToString(" → ")}")
}

@Composable
fun ComparisonSection() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text("+28 horas", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("+3 sesiones", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("+0.8 kg más", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
