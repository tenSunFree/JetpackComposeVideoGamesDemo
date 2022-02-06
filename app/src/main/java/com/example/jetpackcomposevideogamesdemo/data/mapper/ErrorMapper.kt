package com.example.jetpackcomposevideogamesdemo.data.mapper

import android.util.Log
import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseFailure
import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseResponse
import com.example.jetpackcomposevideogamesdemo.remote.RemoteException

class ErrorMapper {

    fun <T>mapRemoteException(e: RemoteException): BaseResponse<T> {
        Log.e(ErrorMapper::class.simpleName, e.message.toString())
        val baseFailure: BaseFailure = when(e) {
            is RemoteException.ClientError -> BaseFailure.ClientError
            is RemoteException.ServerError -> BaseFailure.ServerError
            is RemoteException.NoNetworkError -> BaseFailure.NetworkError
            else -> BaseFailure.GenericError
        }
        return BaseResponse(null, baseFailure)
    }
}