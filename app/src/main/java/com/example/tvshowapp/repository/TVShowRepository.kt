package com.example.tvshowapp.repository

import androidx.lifecycle.LiveData
import com.example.tvshowapp.database.TVShowDAO
import com.example.tvshowapp.model.TVShow

class TVShowRepository(private val tvShowDAO: TVShowDAO) {

    fun getFavourites() : LiveData<List<TVShow>> {
        return tvShowDAO.getFavourites()
    }

    fun getSearchResult(keyword:String){
    }
}