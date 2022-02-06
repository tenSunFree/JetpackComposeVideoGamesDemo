package com.example.jetpackcomposevideogamesdemo.remote

import com.example.jetpackcomposevideogamesdemo.remote.rest.RestApi
import javax.inject.Inject

class NetworkManagerImpl @Inject constructor(
    private val restApi: RestApi
) : NetworkManager {

    override fun restApi(): RestApi = restApi
}