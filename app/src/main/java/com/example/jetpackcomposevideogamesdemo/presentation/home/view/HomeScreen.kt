package com.example.jetpackcomposevideogamesdemo.presentation.home.view

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.jetpackcomposevideogamesdemo.R
import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntity
import com.example.jetpackcomposevideogamesdemo.presentation.common.base.ScreenState
import com.example.jetpackcomposevideogamesdemo.presentation.common.component.GetGamesError
import com.example.jetpackcomposevideogamesdemo.presentation.common.component.LoadingView
import com.example.jetpackcomposevideogamesdemo.presentation.common.component.SnackbarView
import com.example.jetpackcomposevideogamesdemo.presentation.home.model.HomeSideEffect
import com.example.jetpackcomposevideogamesdemo.presentation.home.viewModel.HomeViewModel
import com.example.jetpackcomposevideogamesdemo.presentation.common.theme.EpicWorldTheme
import kotlinx.coroutines.flow.Flow

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    HandleSideEffect(homeViewModel.uiSideEffect(), scaffoldState)
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
        scaffoldState = scaffoldState,
        backgroundColor = Color.Black,
        content = { HomeScreenContent(homeViewModel = homeViewModel) }
    )
}

@ExperimentalFoundationApi
@Composable
fun HomeScreenContent(homeViewModel: HomeViewModel) {
    val context = LocalContext.current
    val errorMessage: String = stringResource(id = R.string.home_screen_scroll_error)
    val action: String = stringResource(id = R.string.all_ok)
    val lifecycleOwner = LocalLifecycleOwner.current
    val stateFlow = homeViewModel.uiState()
    val stateLifecycleAware = remember(lifecycleOwner, stateFlow) {
        stateFlow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val state by stateLifecycleAware.collectAsState(initial = homeViewModel.createInitialState())
    when (state.state) {
        is ScreenState.Loading -> {}
        is ScreenState.Failure -> {
            GetGamesError { homeViewModel.initData() }
        }
        is ScreenState.Success -> {
            val lazyGameItems = state.flow?.collectAsLazyPagingItems()
            lazyGameItems?.let { items ->
                when (lazyGameItems.itemCount) {
                    0 -> LoadingView()
                    else -> LazyVerticalGrid(cells = GridCells.Fixed(1),
                        content = {
                            items(items.itemCount) { index ->
                                items[index]?.let { entity ->
                                    HomeScreenContentItem(entity = entity, click = {
                                        Toast.makeText(
                                            context, entity.name, Toast.LENGTH_SHORT
                                        ).show()
                                    })
                                }
                            }
                        })
                }
                items.apply {
                    when {
                        loadState.refresh is LoadState.Error -> {
                            homeViewModel.handlePaginationDataError()
                        }
                        loadState.append is LoadState.Error -> {
                            homeViewModel.handlePaginationAppendError(errorMessage, action)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreenContentItem(entity: HomeEntity, click: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .wrapContentSize()
            .clickable(onClick = click)
    ) {
        val (bigCard, smallCard, text) = createRefs()
        Card(
            elevation = 20.dp,
            backgroundColor = EpicWorldTheme.colors.background,
            modifier = Modifier
                .constrainAs(bigCard) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .height(170.dp)
                .fillMaxWidth()
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(
                    data = entity.backgroundImage,
                    builder = {
                        placeholder(R.drawable.ic_esports_placeholder_white)
                        crossfade(true)
                    }
                ),
                contentDescription = stringResource(id = R.string.all_game_image_description)
            )
        }
        Card(
            elevation = 20.dp,
            backgroundColor = EpicWorldTheme.colors.background,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(10.dp))
                .width(50.dp)
                .height(50.dp)
                .constrainAs(smallCard) {
                    top.linkTo(bigCard.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(
                    data = entity.backgroundImage,
                    builder = {
                        placeholder(R.drawable.ic_esports_placeholder_white)
                        crossfade(true)
                    }
                ),
                contentDescription = stringResource(id = R.string.all_game_image_description),
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        Text(
            text = entity.name,
            style = EpicWorldTheme.typography.title3,
            color = Color.White,
            maxLines = 1,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(text) {
                    top.linkTo(bigCard.bottom)
                    start.linkTo(smallCard.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
fun HandleSideEffect(uiSideEffectFlow: Flow<HomeSideEffect>, scaffoldState: ScaffoldState) {
    LaunchedEffect(uiSideEffectFlow) {
        val messageHost = SnackbarView(this)
        uiSideEffectFlow.collect { uiSideEffect ->
            when (uiSideEffect) {
                is HomeSideEffect.ShowSnackBar -> {
                    messageHost.showSnackBar(
                        snackbarHostState = scaffoldState.snackbarHostState,
                        message = uiSideEffect.message
                    )
                }
            }
        }
    }
}