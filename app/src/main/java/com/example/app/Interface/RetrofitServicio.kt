package com.example.app.Interface

import com.example.app.Model.Ciudad

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServicio {
    @GET("/api/ciudades")
    fun getListaCiudades():  Call<MutableList<Ciudad>>
}