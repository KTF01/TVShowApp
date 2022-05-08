package com.example.tvshowapp.repository

import android.util.Log
import com.example.tvshowapp.database.TVShowDAO
import com.example.tvshowapp.model.TVShow

import com.example.tvshowapp.network.TvShowType

class TVShowRepository(private val tvShowDAO: TVShowDAO) {

    suspend fun getFavourites() : List<TvShowType> {
        val entityShows:List<TVShow> = tvShowDAO.getFavourites()
        return entityShows.map { es->
            var image:com.example.tvshowapp.model.Image? = null
            if(es.image!=null){
                image = com.example.tvshowapp.model.Image(es.image.medium, es.image.original)
            }
            TvShowType(
                id = es.id,
                summary = es.summary,
                genres = es.genres,
                image = image,
                language = es.language,
                name = es.name,
                premiered = es.premiered,
                type = es.type
            )
        }
    }

    suspend fun insertIntoFavs(show:TvShowType){
        var tmpImage: com.example.tvshowapp.model.Image? = null
        if (show.image!=null){
            tmpImage = com.example.tvshowapp.model.Image(show.image.medium, show.image.original)
        }
        var tmpShow:TVShow = TVShow(
            id = show.id,
            type = show.type,
            premiered = show.premiered,
            name = show.name,
            language = show.language,
            image = tmpImage,
            summary = show.summary,
            genres = show.genres
        )

        tvShowDAO.insertShow(tmpShow)
    }

    fun deletefromFavs(show:TvShowType){
        var tmpImage: com.example.tvshowapp.model.Image? = null
        if (show.image!=null){
            tmpImage = com.example.tvshowapp.model.Image(show.image.medium, show.image.original)
        }
        var tmpShow:TVShow = TVShow(
            id = show.id,
            type = show.type,
            premiered = show.premiered,
            name = show.name,
            language = show.language,
            image = tmpImage,
            summary = show.summary,
            genres = show.genres
        )
        tvShowDAO.deleteShow(tmpShow)
    }

}