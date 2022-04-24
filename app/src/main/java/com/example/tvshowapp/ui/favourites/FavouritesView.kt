package com.example.tvshowapp.ui.favourites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesView: ComponentActivity(){

    private val viewModel: FavouritesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                Text("Valami")
                Button(onClick = {
                    viewModel.loadShows()
                }) {
                    Text(text = "Gomb")
                }
            }


        }

    }
}