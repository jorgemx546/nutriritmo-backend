package com.example.nutriritmo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import kotlin.math.min

@Composable
fun CalendarScreen(
    onEditClick: () -> Unit
) {
    // Fecha base: noviembre 2025
    var currentMonthDate by remember { mutableStateOf(LocalDate.of(2025, 11, 1)) }

    // Nombre del mes en español + año
    val monthName = currentMonthDate.month
        .getDisplayName(TextStyle.FULL, Locale("es", "ES"))
        .replaceFirstChar { it.uppercase() }

    val headerText = "$monthName ${currentMonthDate.year}"

    val daysInMonth = currentMonthDate.lengthOfMonth()
    val days = (1..min(7, daysInMonth)).toList() // mostramos 1–7
    val weekDays = listOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Encabezado mes / año con flechas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "<",
                fontSize = 26.sp,
                modifier = Modifier.clickable {
                    currentMonthDate = currentMonthDate.minusMonths(1)
                }
            )
            Text(
                text = headerText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = ">",
                fontSize = 26.sp,
                modifier = Modifier.clickable {
                    currentMonthDate = currentMonthDate.plusMonths(1)
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Días de la semana
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            weekDays.forEach {
                Text(
                    text = it,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fila de días (más alta y con iconos grandes)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp),              // ⟵ hace más alta toda la franja
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            days.forEach { day ->
                CalendarDayItem(
                    day = day,
                    modifier = Modifier
                        .weight(1f)           // mismo ancho para cada día
                        .fillMaxHeight()      // ocupa toda la altura de la fila
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        SummaryCard()

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onEditClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar calendario")
        }
    }
}

@Composable
fun CalendarDayItem(
    day: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color(0xFFEFEFEF), RoundedCornerShape(24.dp))
            .padding(vertical = 10.dp, horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = day.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        // Íconos grandes
        Text(
            text = "🍽️",
            fontSize = 26.sp
        )
        Text(
            text = "🏋️",
            fontSize = 26.sp
        )
        Text(
            text = "🌮",
            fontSize = 26.sp
        )
    }
}

@Composable
fun SummaryCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Resumen semanal", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Días de ayuno: 5", fontSize = 14.sp)
            Text("Entrenamientos: 3", fontSize = 14.sp)
            Text("Comidas planeadas: 2", fontSize = 14.sp)
        }
    }
}
