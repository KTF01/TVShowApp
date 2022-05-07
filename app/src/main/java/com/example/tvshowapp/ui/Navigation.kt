package com.example.tvshowapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tvshowapp.ui.detail.DetailView
import com.example.tvshowapp.ui.favourites.FavouritesView
import com.example.tvshowapp.ui.search.SearchView

@Composable
fun Navigation(){
    val navController: NavController = rememberNavController()
    NavHost(navController = navController as NavHostController, startDestination = "Favourites") {
        composable("Favourites") { FavouritesView() }
        composable("Detail") { DetailView() }
        composable("Search") { SearchView() }
    }
}