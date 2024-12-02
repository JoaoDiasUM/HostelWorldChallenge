package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.screens.propertyListing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.hostelworldchallenge.R
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.ErrorView
import com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components.LoadingIndicator
import com.example.hostelworldchallenge.utils.ConnectionUtils
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun PropertyListingScreen(navController: NavController, propertyViewModel: PropertyViewModel) {
    val context = LocalContext.current

    val state = propertyViewModel.state.collectAsStateWithLifecycle()

    var isConnectionAvailable = ConnectionUtils.isInternetAvailable(context)

    var refreshing by remember { mutableStateOf(false) }

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = refreshing)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.brown))
            .padding(10.dp)
    ) {

        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                refreshing = true
                isConnectionAvailable = ConnectionUtils.isInternetAvailable(context)
            }
        ) {
            if (state.value.error != null) {
                ErrorView(
                    errorStringId = R.string.generic_error,
                    errorDrawableId = R.drawable.ic_error
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    state = rememberLazyListState()
                ) {
                    item {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = stringResource(id = R.string.property_listing_screen),
                            style = TextStyle(
                                fontSize = 32.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    if (state.value.isLoading) {
                        item { LoadingIndicator() }
                    } else if (isConnectionAvailable) {
                        items(
                            items = state.value.propertyList,
                            key = { it.id }
                        ) { item ->
                            PropertyListingItemScreen(navController, property = item)
                        }
                    } else {
                        item {
                            ErrorView(
                                errorStringId = R.string.no_connection,
                                errorDrawableId = R.drawable.ic_no_connection
                            )
                        }
                    }
                }
            }
        }

        LaunchedEffect(refreshing) {
            if (refreshing) {
                refreshing = false
            }
        }
    }
}