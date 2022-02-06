package com.example.jetpackcomposevideogamesdemo.domain.repository

import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseResponse
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntityList

interface HomeRepository {

    suspend fun getHomeResponse(nextPage: Int): BaseResponse<HomeEntityList>
}