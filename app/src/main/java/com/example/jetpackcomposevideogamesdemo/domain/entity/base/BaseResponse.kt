package com.example.jetpackcomposevideogamesdemo.domain.entity.base

data class BaseResponse<out R>(
    val success: R?,
    val failure: BaseFailure?
)
