package com.example.tvshowapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.tvshowapp.database.TVShowDAO
import com.example.tvshowapp.model.ShowWithGenres
import com.example.tvshowapp.model.TVShow
import com.example.tvshowapp.network.TVMazeAPI
import com.example.tvshowapp.network.TvShowResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TVShowRepository(private val tvShowDAO: TVShowDAO) {

    fun getFavourites() : LiveData<List<ShowWithGenres>> {
        return tvShowDAO.getFavourites()
    }

    fun insertIntoFavs(show:TVShow){
        tvShowDAO.insertShow(show)
    }

    fun deletefromFavs(show:TVShow){
        tvShowDAO.deleteShow(show)
    }

    fun getShowsFromApi(){
        val tvCall = prepareCall()
        tvCall.enqueue(object : Callback<List<TvShowResult>> {
            override fun onResponse(
                call: Call<List<TvShowResult>>,
                response: Response<List<TvShowResult>>
            ) {
                response.body()?.forEach {
                    Log.d("TESZT", it.image.medium)
                }
            }

            override fun onFailure(call: Call<List<TvShowResult>>, t: Throwable) {
                Log.d("TESZT", "FALIOURE!!!!")
            }

        })
    }

    private fun prepareCall(): Call<List<TvShowResult>> {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val tvApi = retrofit.create(TVMazeAPI::class.java)
        return tvApi.getShows("girls")
    }

}