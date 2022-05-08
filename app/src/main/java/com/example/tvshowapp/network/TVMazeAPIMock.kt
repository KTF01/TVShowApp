package com.example.tvshowapp.network

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPIMock {

    @GET("/search/shows")
    fun getShowsAsync(@Query("q") query: String): Response<List<TVShowSearchResponse>>
}