package com.example.tvshowapp.network

import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    @GET("/shows")
    suspend fun getShows(@Query("q") keyword: String):List<TvShowResult>
}