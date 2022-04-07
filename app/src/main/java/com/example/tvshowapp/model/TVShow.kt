package com.example.tvshowapp.model

import androidx.room.Entity

@Entity(tableName = "tvShow")
data class TVShow(
    val id:Int,
    val title:String,
    val language:String,
    val status:String,
    val runtime:Int,
    val premiered: String
    ) {
}