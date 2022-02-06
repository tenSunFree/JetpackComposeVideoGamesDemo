package com.example.jetpackcomposevideogamesdemo.domain.entity.home

data class HomeEntityList(
    val homeEntityList: List<HomeEntity>
)

data class HomeEntity(
    val id: Int,
    val name: String,
    val backgroundImage: String,
    val rating: Double,
)
