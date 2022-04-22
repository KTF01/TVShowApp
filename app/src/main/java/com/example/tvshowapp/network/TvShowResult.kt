package com.example.tvshowapp.network

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

class Image(val medium:String, val original:String){}