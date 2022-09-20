package com.template.montiel.home.ui.component

import Turbo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.template.montiel.home.ui.viewmodel.CategoryViewModel
import com.template.montiel.visual.ui.model.StateUI

@Composable
fun CategoryDetailScreen(
    categoryId: String,
    categoryViewModel: CategoryViewModel
) {

    /**
     * https://proandroiddev.com/jetpack-compose-navigation-architecture-with-viewmodels-1de467f19e1c
     *
     * Regardless of whether you use viewModel() or with Hilt hiltViewModel() to retrieve your ViewModel,
     * they both will call onCleared() when the NavHost finishes transitioning to a different route.
     * So whenever you navigate to another Composable, it will be cleaned up.
     *
     * if you need same viewmodels from other compose view add this code
     *
     * https://developer.android.com/jetpack/compose/libraries#hilt
     *
     * val parentEntry = remember(backStackEntry) {
     *     navController.getBackStackEntry("Parent")
     * }
     * val parentViewModel = hiltViewModel<ParentViewModel>(parentEntry)
     */

    categoryViewModel.getCategoryDetail(categoryId = categoryId)

    val loading = remember { mutableStateOf(false) }

    if (loading.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }

    categoryViewModel.run {
        categoryDetail.let { state ->
            when (state) {
                is StateUI.Success -> {

                    state.data?.let { category ->

                        Column {
                            Text(
                                text = category.description,
                                modifier = Modifier.padding(bottom = 30.dp)
                            )
                            ListTickers(tickets = category.tickets)
                        }

                    }
                    loading.value = false
                }
                is StateUI.Error -> {
                    Text(
                        text = "Error Not Found",
                        modifier = Modifier.padding(bottom = 30.dp)
                    )
                    loading.value = false
                }
                is StateUI.Loading -> loading.value = true
                else -> Unit
            }
        }
    }
}

@Composable
fun ListTickers(
    tickets: List<String>
) {
    LazyColumn {
        items(tickets) { ticket ->
            Text(text = ticket, color = Turbo)
        }
    }
}
