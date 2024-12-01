package com.example.hostelworldchallenge.feature_property_listing.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hostelworldchallenge.common.Constants
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListingDetails.PropertyListingItemDetailsScreen
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing.PropertyListingScreen
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing.PropertyViewModel
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.theme.HostelWorldChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val propertyViewModel: PropertyViewModel = hiltViewModel()

            HostelWorldChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PropertyListingScreen.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(route = Screen.PropertyListingScreen.route) {
                            PropertyListingScreen(navController, propertyViewModel)
                        }
                        composable(
                            route = Screen.PropertyListingDetailsScreen.route,
                            arguments = listOf(navArgument(Constants.NAV_ARGUMENT_SELECTED_PROPERTY_ID) {
                                defaultValue = ""
                            })
                        ) { backStackEntry ->
                            backStackEntry.arguments?.getString(Constants.NAV_ARGUMENT_SELECTED_PROPERTY_ID)
                                ?.let {
                                    PropertyListingItemDetailsScreen(propertyViewModel, it)
                                }
                        }
                    }
                }
            }
        }
    }
}