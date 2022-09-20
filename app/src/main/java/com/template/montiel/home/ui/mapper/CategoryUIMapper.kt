package com.template.montiel.home.ui.mapper

import com.template.montiel.home.data.remote.model.CategoryResponse
import com.template.montiel.home.ui.model.CategoryUI
import com.template.montiel.visual.ui.model.Mapper

class CategoryUIMapper : Mapper<List<CategoryResponse>, List<CategoryUI>> {

    override fun map(input: List<CategoryResponse>): List<CategoryUI> =
        input.map {
            CategoryUI(
                id = it.id,
                description = it.description
            )
        }

}
