package com.example.retrofit_11_daffa.retrofit.api

import com.example.retrofit_11_daffa.retrofit.model.indonesiaResponse
import com.example.retrofit_11_daffa.retrofit.model.provinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("https://learn-retrofit-data.netlify.app/casenumber.json")
    fun getIndonesia(): Call<ArrayList<indonesiaResponse>>

    @GET("https://learn-retrofit-data.netlify.app/casenumberprovince.json")
    fun getProvince(): Call<ArrayList<provinceResponse>>

}