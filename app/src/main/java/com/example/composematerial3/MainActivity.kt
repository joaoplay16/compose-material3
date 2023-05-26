package com.example.composematerial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composematerial3.ui.screens.BottomSheetScreen
import com.example.composematerial3.ui.screens.HomeScreen
import com.example.composematerial3.ui.screens.Routes
import com.example.composematerial3.ui.screens.SearchScreen
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   DefaultNavHost()
                }
            }
        }
    }
}

@Composable
fun DefaultNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.HOME_SCREEN.name,
    ){

        composable(Routes.HOME_SCREEN.name){
            HomeScreen(
                onSearchScreen = {
                    navController.navigate(Routes.SEARCH_SCREEN.name)
                },
                onBottomSheetScreen = {
                    navController.navigate(Routes.BOTTOM_SHEET_SCREEN.name)
                }
            )
        }

        composable(Routes.SEARCH_SCREEN.name){
            SearchScreen()
        }

        composable(Routes.BOTTOM_SHEET_SCREEN.name){
            BottomSheetScreen()
        }
    }
}

