package com.example.jetpackcomposevideogamesdemo.presentation.home.model

import androidx.paging.PagingData
import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseFailure
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntity
import com.example.jetpackcomposevideogamesdemo.presentation.common.base.ScreenState
import kotlinx.coroutines.flow.Flow

data class HomeState(
    val state: ScreenState,
    val flow: Flow<PagingData<HomeEntity>>?,
    val failure: BaseFailure?
)
