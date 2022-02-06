package com.example.jetpackcomposevideogamesdemo.presentation.home.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.jetpackcomposevideogamesdemo.domain.entity.base.BaseFailure
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntity
import com.example.jetpackcomposevideogamesdemo.domain.interactor.HomePagingSource
import com.example.jetpackcomposevideogamesdemo.presentation.common.base.BaseViewModel
import com.example.jetpackcomposevideogamesdemo.presentation.common.base.ScreenState
import com.example.jetpackcomposevideogamesdemo.presentation.home.model.HomeSideEffect
import com.example.jetpackcomposevideogamesdemo.presentation.home.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val homePagingSource: HomePagingSource
) : BaseViewModel<HomeState, HomeSideEffect>(savedStateHandle) {

    override fun createInitialState(): HomeState = HomeState(
        ScreenState.Loading, null, null
    )

    override fun initData() = intent {
        val result = getAllGames()
        reduce {
            state.copy(state = ScreenState.Success, flow = result.flow, failure = null)
        }
    }

    fun handlePaginationDataError() = intent {
        reduce {
            state.copy(
                state = ScreenState.Failure,
                flow = null,
                failure = BaseFailure.ServerError
            )
        }
    }

    fun handlePaginationAppendError(message: String, action: String) = intent {
        postSideEffect(HomeSideEffect.ShowSnackBar(message = message, action = action))
    }

    private fun getAllGames(): Pager<Int, HomeEntity> {
        return Pager(PagingConfig(50)) {
            homePagingSource
        }
    }
}