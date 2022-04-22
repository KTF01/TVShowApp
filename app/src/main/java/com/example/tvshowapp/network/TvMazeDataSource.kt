package com.example.tvshowapp.network

class TvMazeDataSource  constructor(
    private val tvMazeApi:TVMazeAPI
) {
    suspend fun getMoneyRates(): List<TvShowResult> {
        return tvMazeApi.getShows("girls")
    }
}