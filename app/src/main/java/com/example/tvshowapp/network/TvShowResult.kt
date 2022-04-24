package com.example.tvshowapp.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)

class TvShowResult(
    @SerializedName("id")
    val id:Integer,
    @SerializedName("name")
    val name:String,
    @SerializedName("type")
    val type:String,
    @SerializedName("language")
    val language:String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("premiered")
    val premiered:String,
    @SerializedName("image")
    val image:Image
) {
}
//@JsonClass(generateAdapter = true)
class Image(
    @SerializedName("medium")
    val medium:String,
    @SerializedName("original")
    val original:String){}