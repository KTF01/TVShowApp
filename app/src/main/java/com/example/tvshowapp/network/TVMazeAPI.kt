package com.example.tvshowapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    @GET("/shows")
    fun getShows(@Query("q") keyword: String):Call<List<TvShowResult>>
}