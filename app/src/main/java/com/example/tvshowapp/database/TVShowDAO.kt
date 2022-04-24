package com.example.tvshowapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tvshowapp.model.ShowWithGenres
import com.example.tvshowapp.model.TVShow

@Dao
interface TVShowDAO {

    @Transaction
    @Query("SELECT * FROM tvShow")
    fun getFavourites(): LiveData<List<ShowWithGenres>>

    @Query("SELECT * FROM tvShow WHERE id=:id ")
    fun loadSingle(id: Int): LiveData<ShowWithGenres>

    @Insert
    fun insertShow(tvShow: TVShow)

    @Delete
    fun deleteShow(tvShow: TVShow)
}