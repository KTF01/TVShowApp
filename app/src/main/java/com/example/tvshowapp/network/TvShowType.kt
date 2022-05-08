package com.example.tvshowapp.network

import com.example.tvshowapp.model.Image
import com.google.gson.annotations.SerializedName

class TvShowType(
    @SerializedName("id")
    val id:Int,
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
    val image: Image?,
    @SerializedName("summary")
    val summary:String
) {
}
class Image(
    @SerializedName("medium")
    val medium:String,
    @SerializedName("original")
    val original:String
    ){}

class TVShowSearchResponse(
    @SerializedName("score")
    val score: Float,
    @SerializedName("show")
    val show: TvShowType
){}