package com.example.jetpackcomposevideogamesdemo.remote.rest

import com.example.jetpackcomposevideogamesdemo.remote.model.request.HomeRequest
import com.example.jetpackcomposevideogamesdemo.remote.model.response.HomeResponse
import com.example.jetpackcomposevideogamesdemo.remote.retrofit.RetrofitApi
import javax.inject.Inject

class RestApiImpl @Inject constructor(
    private val retrofitApi: RetrofitApi
) : RestApi {

    override suspend fun getHomeResponse(homeRequest: HomeRequest): HomeResponse {
        return retrofitApi.getHomeResponse(homeRequest.nextPage, homeRequest.pageSize)
    }
}