package com.example.jetpackcomposevideogamesdemo.remote.retrofit

import com.example.jetpackcomposevideogamesdemo.remote.model.response.HomeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("/api/games")
    suspend fun getHomeResponse(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
    ): HomeResponse
}