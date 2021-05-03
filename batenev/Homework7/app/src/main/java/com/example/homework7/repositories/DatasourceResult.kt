package com.example.homework7.repositories

/* Have no idea how this should be called. Maybe i just overengineered the data flow :0  */
sealed class DatasourceResult<out T> {
    data class Data<out T>(val data: T) : DatasourceResult<T>()
    data class Error(val type: DatasourceError) : DatasourceResult<Nothing>()
}

enum class DatasourceError {
    EMPTY,
    NETWORK,
    UNKNOWN,
    API,
}