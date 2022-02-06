package com.example.jetpackcomposevideogamesdemo.data

import com.example.jetpackcomposevideogamesdemo.remote.NetworkManager
import com.example.jetpackcomposevideogamesdemo.remote.NetworkManagerImpl
import com.example.jetpackcomposevideogamesdemo.remote.rest.RestApi
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val restApi: RestApi
) : DataSource {

    override fun api(): NetworkManager = NetworkManagerImpl(restApi = restApi)
}