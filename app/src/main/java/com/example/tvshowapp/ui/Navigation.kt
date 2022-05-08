package com.example.tvshowapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tvshowapp.network.TvShowType
import com.example.tvshowapp.ui.detail.DetailView
import com.example.tvshowapp.ui.favourites.FavouritesView
import com.example.tvshowapp.ui.search.SearchView
import com.google.gson.Gson

@Composable
fun Navigation(){
    val gson = Gson()

    val navController: NavController = rememberNavController()
    NavHost(navController = navController as NavHostController, startDestination = "Favourites") {
        composable("Favourites") { FavouritesView(navController = navController) }
        composable("Detail/show={show}") {backStackEntry ->
            val showJson = backStackEntry.arguments?.getString("show")
            val showObject:TvShowType = gson.fromJson(showJson?.replace("{slash}", "/"), TvShowType::class.java)
            DetailView(showObject, navController = navController)
        }
        composable("Search") { SearchView(navController) }
    }
}