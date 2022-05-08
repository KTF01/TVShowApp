package com.example.tvshowapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShow")
data class TVShow(
    @PrimaryKey val id:Int,
    val name:String,
    val type:String,
    val language:String,
    val premiered: String,
    val summary:String,
    val genres:List<String>,
    @Embedded
    val image: Image?,
    ) {
}



