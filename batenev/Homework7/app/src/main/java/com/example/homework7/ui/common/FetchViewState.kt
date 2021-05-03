package com.example.homework7.ui.common

sealed class FetchViewState<out T> {
    fun isLoading(): Boolean = this is Loading
    fun isSuccess(): Boolean = this is Data
    fun dataValue(): T? = (this as? Data)?.data

    data class Data<out T>(val data: T) : FetchViewState<T>()
    object ApiError : FetchViewState<Nothing>()
    object UnknownError : FetchViewState<Nothing>()
    object NetworkError : FetchViewState<Nothing>()
    object Empty : FetchViewState<Nothing>()
    object Loading : FetchViewState<Nothing>()
}