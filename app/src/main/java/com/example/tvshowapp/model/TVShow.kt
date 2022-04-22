package com.example.tvshowapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShow")
data class TVShow(
    @PrimaryKey val id:Int,
    val title:String,
    val language:String,
    val status:String,
    val runtime:Int,
    val premiered: String,
    val image: String
    ) {
}