package com.example.examenfinal2.Buscador

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServisLOL {
    @GET
    suspend fun getChamps (@Url url:String):Response<champResponse>
}