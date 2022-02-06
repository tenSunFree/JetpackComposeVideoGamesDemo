package com.example.jetpackcomposevideogamesdemo.remote.model.request

import com.example.jetpackcomposevideogamesdemo.remote.ApiConstants

data class HomeRequest(
    val nextPage: Int,
    val pageSize: Int = ApiConstants.PAGE_SIZE
)
