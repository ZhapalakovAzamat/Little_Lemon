package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Destinations.Onboarding.route) {
        composable(Destinations.Home.route) {
            HomeScreen(navHostController)
        }
        composable(Destinations.Profile.route) {
            ProfileScreen()
        }
        composable(Destinations.Onboarding.route) {
            Onboarding(navHostController)
        }
    }
}