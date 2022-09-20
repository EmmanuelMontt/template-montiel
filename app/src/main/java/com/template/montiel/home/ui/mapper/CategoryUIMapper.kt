package com.template.montiel.home.ui.mapper

import com.template.montiel.home.data.remote.model.CedearsCategoryResponse
import com.template.montiel.home.ui.model.CategoryUI
import com.template.montiel.visual.ui.model.Mapper

class CategoryUIMapper : Mapper<CedearsCategoryResponse, List<CategoryUI>> {

    override fun map(input: CedearsCategoryResponse): List<CategoryUI> =
        mutableMapOf<String, CategoryUI>().let { map ->
            input.categories.forEach { category ->
                map[category.id] = CategoryUI(
                    id = category.id,
                    description = category.description
                )
            }

            input.tickers.forEach {
                it.categories.forEach { categoryId ->
                    map[categoryId]?.tickets?.add(it.ticker)
                }
            }

            map.toList().map {
                it.second
            }
        }

}
