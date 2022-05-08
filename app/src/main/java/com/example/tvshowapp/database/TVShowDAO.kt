package com.example.tvshowapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tvshowapp.model.TVShow

@Dao
interface TVShowDAO {
    @Query("SELECT * FROM tvShow")
    suspend fun getFavourites(): List<TVShow>

    @Insert
    suspend fun insertShow(tvShow: TVShow)

    @Delete
    fun deleteShow(tvShow: TVShow)
}