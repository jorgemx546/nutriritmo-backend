package com.example.nutriritmo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun SplashScreen(onFinish: () -> Unit) {
    // Espera 2 segundos y luego pasa a la app
    LaunchedEffect(Unit) {
        delay(2000)
        onFinish()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Logo de NutriRitmo (debe existir en res/drawable)
            Image(
                painter = painterResource(id = R.drawable.logo_nutriritmo),
                contentDescription = "Logo NutriRitmo",
                modifier = Modifier.size(180.dp)
            )




            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "NutriRitmo",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Tu equilibrio entre ayuno, ejercicio y sabor mexicano",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}
