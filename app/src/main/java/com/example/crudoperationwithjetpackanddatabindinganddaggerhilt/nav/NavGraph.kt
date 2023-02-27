package com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.screen.AddDataScreen
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.screen.GetDataScreen
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.screen.MainScreen
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.util.SharedViewModel

@Composable
fun NavGraph(
    navController: NavController, sharedViewModel: SharedViewModel
) {
    NavHost(
        // if error occur change the  as NavHostController
        navController = navController as NavHostController,
        startDestination = Screens.MainScreen.route
    ) {
        //Main Screen
        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(navController = navController)
        }

        //get data Screen
        composable(
            route = Screens.GetDataScreen.route
        ) {
            GetDataScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        //add data Screen
        composable(
            route = Screens.AddDataScreen.route
        ) {
            AddDataScreen(navController = navController, sharedViewModel = sharedViewModel)
        }




    }


}