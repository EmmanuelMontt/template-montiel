package com.template.montiel.home.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.template.montiel.home.ui.model.CategoryUI
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

    val loading = remember { mutableStateOf(true) }
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
        categories.let { state ->
            when (state) {
                is StateUI.Success -> {
                    state.data?.let { categories ->

                        Column {
                            Text(
                                text = "Categorias todas las tengo Y CATEGORY $categoryId",
                                modifier = Modifier.padding(bottom = 30.dp)
                            )

                        }

                    }
                    loading.value = false
                }
                is StateUI.Error -> {
                    LostConnectionView()
                    loading.value = false
                }
                is StateUI.Loading -> loading.value = true
                is StateUI.Init -> getAllCategories()
            }
        }
    }
}