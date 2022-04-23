package com.example.tvshowapp.ui.favourites

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.database.AppDatabase
import com.example.tvshowapp.model.TVShow
import com.example.tvshowapp.network.TvMazeDataSource
import com.example.tvshowapp.repository.TVShowRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val networkDataSource:TvMazeDataSource,
    application:Application,
): AndroidViewModel(application) {

    private val repository : TVShowRepository

    private val favouriteShows: LiveData<List<TVShow>>
    init {
        val showDao = AppDatabase.getInstance(application).tvShowDao()
        repository = TVShowRepository(showDao)
        favouriteShows = repository.getFavourites()
        //loadShows()

        //viewModelScope.launch {
        //    loadShows()
        //}
    }


    public fun loadShows() {
        viewModelScope.launch {
            try {
                val results = networkDataSource.getMoneyRates()
                Log.i("bla", "BLABLA")
            } catch (e: Exception) {

            }
        }

    }


}