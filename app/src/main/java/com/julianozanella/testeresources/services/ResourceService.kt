package com.julianozanella.testeresources.services

import com.julianozanella.testeresources.models.Anonimous
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ResourceService {

    //na chamada eh passado o argumento da consulta, value: eh a key, e a string query eh o value
    @GET("get_resources_since")//a chamada fica: .../get_resources_since?fbclid=....string passada
    fun getResources(@Query("fbclid") query: String): Call<List<Anonimous>>
}