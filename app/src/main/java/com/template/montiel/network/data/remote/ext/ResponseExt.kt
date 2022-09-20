package com.template.montiel.network.data.remote.ext

import com.template.montiel.network.data.remote.exception.ApiMissingException
import retrofit2.Response

fun <R, T> Response<R>.asResponse(action: (R) -> T): T {
    val body = body()
    if (isSuccessful && body != null) {
        return action.invoke(body)
    } else {
        throw manageErrors()
    }
}

/**
 * Manage multiple error servers
 */
fun <R> Response<R>.manageErrors() =
    when (code()) {
        400 -> ApiMissingException()
        else -> Exception()
    }
