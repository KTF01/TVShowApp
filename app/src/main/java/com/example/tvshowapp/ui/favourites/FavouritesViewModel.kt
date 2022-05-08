package com.example.tvshowapp.ui.favourites

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.database.AppDatabase
import com.example.tvshowapp.network.TvShowType
import com.example.tvshowapp.repository.TVShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


class FavouritesViewModel(application:Application): AndroidViewModel(application) {

    private val repository : TVShowRepository

    var favouriteShows by mutableStateOf<List<TvShowType>>(emptyList())

    init {
        val showDao = AppDatabase.getInstance(application).tvShowDao()
        repository = TVShowRepository(showDao)
        getFavourites()
    }

    private fun getFavourites(){
        viewModelScope.launch(Dispatchers.IO) {
            delay(100)
            val shows = repository.getFavourites()
            favouriteShows = shows

        }
    }




}