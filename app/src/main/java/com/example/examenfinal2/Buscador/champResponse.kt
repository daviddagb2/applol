package com.example.examenfinal2.Buscador

import com.google.gson.annotations.SerializedName

data class champResponse (
    @SerializedName("type") val type:String,
    @SerializedName("data") val data:List<champModel>


)