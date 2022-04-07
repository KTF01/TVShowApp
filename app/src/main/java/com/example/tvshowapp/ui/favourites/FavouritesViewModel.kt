package com.example.tvshowapp.ui.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tvshowapp.database.AppDatabase
import com.example.tvshowapp.model.TVShow
import com.example.tvshowapp.repository.TVShowRepository

class FavouritesViewModel(application:Application): AndroidViewModel(application) {

    private val repository : TVShowRepository

    private val favouriteShows: LiveData<List<TVShow>>

    init {
        val showDao = AppDatabase.getInstance(application).tvShowDao()
        repository = TVShowRepository(showDao)
        favouriteShows = repository.getFavourites()
    }
}