package com.example.jetpackcomposevideogamesdemo.injection

import android.content.Context
import com.example.jetpackcomposevideogamesdemo.data.DataSource
import com.example.jetpackcomposevideogamesdemo.data.DataSourceImpl
import com.example.jetpackcomposevideogamesdemo.remote.rest.RestApi
import com.example.jetpackcomposevideogamesdemo.remote.rest.RestApiImpl
import com.example.jetpackcomposevideogamesdemo.remote.retrofit.RetrofitApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesContext(@ApplicationContext context: Context) = context

    @Provides
    fun providesRestApi(retrofitApi: RetrofitApi): RestApi = RestApiImpl(retrofitApi = retrofitApi)

    @Provides
    fun providesDataSource(restApi: RestApi): DataSource = DataSourceImpl(restApi = restApi)

    @Provides
    fun providesDispatcher() = Dispatchers.IO
}