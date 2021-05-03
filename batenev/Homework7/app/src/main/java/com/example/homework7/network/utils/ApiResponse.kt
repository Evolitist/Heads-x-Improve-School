package com.example.homework7.network.utils

import kotlinx.serialization.Serializable
import java.io.IOException

sealed class ApiResponse<out TData : Any, out TError : Any> {

    data class Success<TData : Any>(val data: TData) : ApiResponse<TData, Nothing>()

    data class ApiError<TError : Any>(
        val errorBody: TError?,
        val code: Int
    ) : ApiResponse<Nothing, TError>()

    data class NetworkError(val error: IOException) : ApiResponse<Nothing, Nothing>()

    data class UnknownError(val error: Throwable?) : ApiResponse<Nothing, Nothing>()

    object Empty : ApiResponse<Nothing, Nothing>()

}

@Serializable
data class SWApiError(
    val code: Int,
    val message: String
)