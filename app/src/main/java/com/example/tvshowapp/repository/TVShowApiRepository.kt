package com.example.tvshowapp.repository

import com.example.tvshowapp.network.TVMazeAPI
import com.example.tvshowapp.network.TvShowType
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TVShowApiRepository {

    suspend fun fetchShows(queryText: String):List<TvShowType>?{
        val api = prepareApi()

        val deferredResponse = api.getShowsAsync(queryText).await()

        return if (deferredResponse.isSuccessful){
            deferredResponse.body()?.map { response-> response.show }
        }else{
            throw Exception()
        }
    }

    private fun prepareApi():TVMazeAPI{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = Builder().addInterceptor(interceptor).build()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(TVMazeAPI::class.java)
    }
}