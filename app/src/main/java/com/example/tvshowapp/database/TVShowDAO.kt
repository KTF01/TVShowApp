package com.example.tvshowapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tvshowapp.model.TVShow

@Dao
interface TVShowDAO {

    @Query("SELECT * FROM tvShow")
    fun getFavourites(): LiveData<List<TVShow>>

    @Query("SELECT * FROM tvShow WHERE id=:id ")
    fun loadSingle(id: Int): LiveData<TVShow>

    @Insert
    suspend fun insertCity(tvShow: TVShow)

    @Delete
    suspend fun deleteFromFavourites(tvShow: TVShow)
}