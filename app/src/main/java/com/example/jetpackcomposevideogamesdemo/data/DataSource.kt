package com.example.jetpackcomposevideogamesdemo.data

import com.example.jetpackcomposevideogamesdemo.remote.NetworkManager

interface DataSource {
    fun api(): NetworkManager
}