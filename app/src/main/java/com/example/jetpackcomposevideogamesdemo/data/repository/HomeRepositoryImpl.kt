package com.example.jetpackcomposevideogamesdemo.data.repository

import com.example.jetpackcomposevideogamesdemo.data.DataSource
import com.example.jetpackcomposevideogamesdemo.data.mapper.ErrorMapper
import com.example.jetpackcomposevideogamesdemo.data.mapper.HomeMapper
import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseResponse
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntityList
import com.example.jetpackcomposevideogamesdemo.domain.repository.HomeRepository
import com.example.jetpackcomposevideogamesdemo.remote.RemoteException
import com.example.jetpackcomposevideogamesdemo.remote.model.request.HomeRequest
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val source: DataSource
) : HomeRepository {

    private val homeMapper = HomeMapper()
    private val errorMapper = ErrorMapper()

    override suspend fun getHomeResponse(nextPage: Int): BaseResponse<HomeEntityList> {
        return try {
            source.api().restApi().getHomeResponse(HomeRequest(nextPage)).run {
                homeMapper.mapHomeResponse(this)
            }
        } catch (e: RemoteException) {
            errorMapper.mapRemoteException(e)
        }
    }
}