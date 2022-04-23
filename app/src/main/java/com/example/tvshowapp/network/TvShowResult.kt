package com.example.tvshowapp.network

import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
class TvShowResult(
    val id:Integer,
    val name:String,
    val type:String,
    val language:String,
    val genres: List<String>,
    val premiered:String,
    val image:List<Image>
) {
}
//@JsonClass(generateAdapter = true)
class Image(val medium:String, val original:String){}