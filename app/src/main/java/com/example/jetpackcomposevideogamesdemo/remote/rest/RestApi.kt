package com.example.jetpackcomposevideogamesdemo.remote.rest

import com.example.jetpackcomposevideogamesdemo.remote.model.request.HomeRequest
import com.example.jetpackcomposevideogamesdemo.remote.model.response.HomeResponse

interface RestApi {
    suspend fun getHomeResponse(homeRequest: HomeRequest): HomeResponse
 }