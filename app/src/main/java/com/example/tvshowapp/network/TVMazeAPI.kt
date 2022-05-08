package com.example.tvshowapp.network

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    @GET("/search/shows")
    fun getShowsAsync(@Query("q") query: String): Deferred<Response<List<TVShowSearchResponse>>>
}