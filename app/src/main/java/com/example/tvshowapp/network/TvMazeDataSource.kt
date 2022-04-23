package com.example.tvshowapp.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvMazeDataSource @Inject constructor(
    private val tvMazeApi:TVMazeAPI
) {
    suspend fun getMoneyRates(): List<TvShowResult> {
        return tvMazeApi.getShows("girls")
    }
}