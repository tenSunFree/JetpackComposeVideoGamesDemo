package com.example.jetpackcomposevideogamesdemo.domain.interactor

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntity
import com.example.jetpackcomposevideogamesdemo.domain.repository.HomeRepository
import javax.inject.Inject

class HomePagingSource @Inject constructor(
    private val repository: HomeRepository
) : PagingSource<Int, HomeEntity>() {

    override fun getRefreshKey(state: PagingState<Int, HomeEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeEntity> {
        val nextPage = params.key ?: 1
        val response = repository.getHomeResponse(nextPage)
        return if (response.success == null) {
            LoadResult.Error(Exception(response.failure.toString()))
        } else {
            LoadResult.Page(
                data = response.success.homeEntityList,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        }
    }
}