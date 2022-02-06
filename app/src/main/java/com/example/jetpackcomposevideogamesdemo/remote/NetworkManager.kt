package com.example.jetpackcomposevideogamesdemo.remote

import com.example.jetpackcomposevideogamesdemo.remote.rest.RestApi

interface NetworkManager {
    fun restApi(): RestApi
}