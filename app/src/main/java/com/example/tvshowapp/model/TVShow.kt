package com.example.tvshowapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "tvShow")
data class TVShow(
    @PrimaryKey val id:Int,
    val name:String,
    val type:String,
    val language:String,
    val premiered: String,
    @Embedded
    val image: Image,

    ) {
}

@Entity(tableName = "genre")
data class Genre(
    @PrimaryKey val genreId:Int,
    val genre:String,
    val showId:Int
)

data class ShowWithGenres(
    @Embedded val show:TVShow,
    @Relation(
        parentColumn = "id",
        entityColumn = "showId"
    )
    val genres:List<Genre>
)

