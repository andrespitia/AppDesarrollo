package com.example.app.Common

import com.example.app.Interface.RetrofitServicio
import com.example.app.Retrofit.RetrofitClient


object Common {

    private val BASE_URL = "https://pruebas.monolegal.co"

    val retrofitServicio: RetrofitServicio
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServicio::class.java)

}