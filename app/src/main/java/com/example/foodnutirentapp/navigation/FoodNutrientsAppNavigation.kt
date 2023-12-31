package com.example.foodnutirentapp.navigation

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodnutirentapp.screens.details.DetailsScreen
import com.example.foodnutirentapp.screens.home.HomeScreen

@Composable
fun FoodNutrientsAppNavigation(
    componentActivity: ComponentActivity
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = FoodItemsScreens.HomeScreen.name) {
        composable(route = FoodItemsScreens.HomeScreen.name) {
            HomeScreen(navController,componentActivity)
        }
        composable(route = FoodItemsScreens.DetailsScreen.name+"/{food}",
            arguments = listOf(navArgument(name = "food") {type = NavType.StringType})){
                backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("food"),componentActivity
            )
        }
    }


}