package com.example.nutriritmo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AuthNavHost(
    navController: NavHostController,
    onAuthSuccess: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.WELCOME
    ) {

        composable(AppDestinations.WELCOME) {
            WelcomeScreen(navController)
        }

        composable(AppDestinations.LOGIN) {
            LoginScreen(
                navController = navController,
                onSuccess = { onAuthSuccess() }
            )
        }

        composable(AppDestinations.REGISTER) {
            RegisterScreen(
                navController = navController,
                onSuccess = { onAuthSuccess() }
            )
        }
    }
}
