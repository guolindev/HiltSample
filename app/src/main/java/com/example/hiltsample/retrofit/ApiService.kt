package com.example.hiltsample.retrofit

import retrofit2.http.GET

interface ApiService {

    @GET("api/china")
    suspend fun getProvinces(): List<Province>

}