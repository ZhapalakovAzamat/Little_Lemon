package com.example.littlelemon

import android.service.autofill.UserData
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(navHostController: NavHostController, userData: Boolean){
    NavHost(
        navController = navHostController
        , startDestination =
        if (userData) Destinations.Onboarding.route
        else Destinations.Home.route
    ) {
        composable(Destinations.Home.route) {
            HomeScreen(navHostController)
        }
        composable(Destinations.Profile.route) {
            ProfileScreen(navHostController)
        }
        composable(Destinations.Onboarding.route) {
            Onboarding(navHostController)
        }
    }
}

const val USER_DATA = "userData"
const val FIRST_NAME = "firstName"
const val LAST_NAME = "lastName"
const val EMAIL = "email"