package com.example.tvshowapp.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.database.AppDatabase

import com.example.tvshowapp.network.TvShowType
import com.example.tvshowapp.repository.TVShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application:Application):AndroidViewModel(application) {

    private val repository : TVShowRepository
    init {
        val showDao = AppDatabase.getInstance(application).tvShowDao()
        repository = TVShowRepository(showDao)
    }

    fun getGenresString(show:TvShowType):String{
        var result:String = ""
        for(item in show.genres){
            result+= "$item, "
        }
        result = result.substring(0, result.length-2)
        return result
    }

    fun deleteShow(show:TvShowType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletefromFavs(show)
        }
    }



}
