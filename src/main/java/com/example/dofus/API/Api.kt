package com.example.dofus.API

import com.example.dofus.`object`.monster
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Api {
    @GET("/monsters")
    fun getListMonsters(): Call<List<monster>>

    companion object {
        private const val url = "https://fr.dofus.dofapi.fr/"

        fun create():Api {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(Api::class.java)
        }

    }


}