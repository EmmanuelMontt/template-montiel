package com.template.montiel.home.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.montiel.home.domain.repository.CategoryRepository
import com.template.montiel.home.ui.mapper.CategoryUIMapper
import com.template.montiel.home.ui.model.CategoryUI
import com.template.montiel.visual.ui.model.StateUI
import com.template.montiel.visual.ui.model.asStateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val categoryUIMapper: CategoryUIMapper
) : ViewModel() {

    var categories by mutableStateOf<StateUI<List<CategoryUI>>>(StateUI.Init())

    fun getAllCategories() {
        viewModelScope.launch {
            categoryRepository.getAllCategories().collect { result ->
                categories = result.asStateUI(
                    mapper = categoryUIMapper
                )
            }
        }
    }
}