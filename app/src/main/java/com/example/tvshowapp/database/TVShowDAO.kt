package com.example.tvshowapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tvshowapp.model.TVShow

@Dao
interface TVShowDAO {

    @Transaction
    @Query("SELECT * FROM tvShow")
    suspend fun getFavourites(): List<TVShow>

    @Query("SELECT * FROM tvShow WHERE id=:id ")
    fun loadSingle(id: Int): LiveData<TVShow>

    @Insert
    suspend fun insertShow(tvShow: TVShow)

    @Delete
    fun deleteShow(tvShow: TVShow)
}