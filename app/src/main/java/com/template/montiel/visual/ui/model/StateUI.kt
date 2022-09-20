package com.template.montiel.visual.ui.model

import com.template.montiel.core.domain.model.Result

sealed interface StateUI<out T> {
    data class Loading<T>(val data: T? = null) : StateUI<T>
    data class Error<T>(val data: Throwable? = null) : StateUI<T>
    data class Success<T>(val data: T? = null) : StateUI<T>
    data class Init<T>(val data: T? = null) : StateUI<T>
}

fun <E, UI> Result<E>.asStateUI(
    mapper: Mapper<E, UI>,
    success: ((UI) -> StateUI<UI>)? = null
): StateUI<UI> =
    when (this) {
        is Result.Success -> {
            mapper.map(data).let { ui ->
                success?.invoke(ui) ?: StateUI.Success(ui)
            }
        }
        is Result.Loading -> StateUI.Loading()
        is Result.Error -> StateUI.Error(exception)
    }