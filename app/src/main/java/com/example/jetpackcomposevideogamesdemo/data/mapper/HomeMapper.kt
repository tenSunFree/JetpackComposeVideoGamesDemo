package com.example.jetpackcomposevideogamesdemo.data.mapper

import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseResponse
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntityList
import com.example.jetpackcomposevideogamesdemo.remote.model.response.HomeResponse
import com.example.jetpackcomposevideogamesdemo.remote.model.response.toEntity

class HomeMapper {

    fun mapHomeResponse(response: HomeResponse): BaseResponse<HomeEntityList> {
        return BaseResponse(HomeEntityList(response.results.toEntity()), null)
    }
}