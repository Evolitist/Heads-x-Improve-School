package com.example.homework7.network.utils

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class ApiResponseAdapter<TData : Any, TError : Any>(
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, TError>
) : CallAdapter<TData, Call<ApiResponse<TData, TError>>> {

    override fun adapt(call: Call<TData>): Call<ApiResponse<TData, TError>> {
        return SWApiCall(call, errorBodyConverter)
    }

    override fun responseType(): Type = successType
}