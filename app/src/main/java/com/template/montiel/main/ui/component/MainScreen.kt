package com.template.montiel.main.ui.component

import Turbo
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.template.montiel.home.ui.component.CategoryDetailScreen
import com.template.montiel.home.ui.component.CategoryListScreen
import com.template.montiel.home.ui.viewmodel.CategoryViewModel
import com.template.montiel.visual.ui.compose.theme.TemplateTheme

@Composable
fun MainComponent(
    content: @Composable (PaddingValues) -> Unit
) {
    TemplateTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Template App")
                    },
                    backgroundColor = Turbo,
                    contentColor = Color.Black,
                    elevation = 12.dp
                )
            },
            content = content
        )
    }
}

@Composable
fun MainNavigation(
    navController: NavHostController
) {

    // Fixme. Send all string routes ang parameters to RouteClass
    NavHost(
        navController = navController,
        startDestination = "categories_list",
    ) {

        composable(
            route = "categories_list"
        ) {
            CategoryListScreen { category ->
                navController.navigate("category_detail/${category.id}")
            }
        }

        composable(
            route = "category_detail/{categoryID}",
            arguments = listOf(navArgument("categoryID") { type = NavType.StringType })
        ) { backStackEntry ->

            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("categories_list")
            }
            val categoryViewModel: CategoryViewModel = hiltViewModel(parentEntry)

            backStackEntry.arguments?.getString("categoryID")?.let { categoryId ->
                CategoryDetailScreen(
                    categoryId = categoryId,
                    categoryViewModel = categoryViewModel
                )
            }

        }
    }
}
