package com.template.montiel.home.ui.component

import Turbo
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
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
fun CategoryListScreen(
    onClickCategory: (CategoryUI) -> Unit
) {

    val homeViewModel: CategoryViewModel = hiltViewModel()
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

    homeViewModel.run {
        categories.let { state ->
            when (state) {
                is StateUI.Success -> {
                    state.data?.let { categories ->

                        Column {
                            Text(text = "Categorias", modifier = Modifier.padding(bottom = 30.dp))
                            ListCategories(
                                categories = categories,
                                onClickCategory = onClickCategory
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

@Composable
fun ListCategories(
    categories: List<CategoryUI>,
    onClickCategory: (CategoryUI) -> Unit
) {
    LazyColumn {
        items(categories) { category ->

            OutlinedButton(
                onClick = {
                    onClickCategory.invoke(category)
                },
                border = BorderStroke(1.dp, Turbo),
                shape = RoundedCornerShape(50),
            ) {
                Text(text = category.description, color = Turbo)
            }

        }
    }
}

@Composable
fun LostConnectionView() {
    Text(text = "No hay internet")
}
