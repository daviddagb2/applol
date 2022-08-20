package com.example.examenfinal2.Buscador

import com.google.gson.annotations.SerializedName

data class champModel(
    @SerializedName("name") val name:String,
    @SerializedName("title") val title:String,
    @SerializedName("blurb") val blurd:String,
    @SerializedName("image") val image:ImagenModel
)
