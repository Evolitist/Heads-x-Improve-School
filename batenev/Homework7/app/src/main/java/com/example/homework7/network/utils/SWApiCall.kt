package com.example.homework7.network.utils

import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.lang.UnsupportedOperationException

class SWApiCall<TData : Any, TError : Any>(
    private val delegate: Call<TData>,
    private val errorConverter: Converter<ResponseBody, TError>
) : Call<ApiResponse<TData, TError>> {

    override fun enqueue(callback: Callback<ApiResponse<TData, TError>>) {
        return delegate.enqueue(object : Callback<TData> {
            override fun onResponse(call: Call<TData>, response: Response<TData>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@SWApiCall,
                            Response.success(ApiResponse.Success(body))
                        )
                    } else {
                        //successful response w/o  body
                        callback.onResponse(
                            this@SWApiCall,
                            Response.success(ApiResponse.Empty)
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null || error.contentLength() == 0L -> null
                        else -> {
                            try {
                                errorConverter.convert(error)
                            } catch (e: Exception) {
                                null
                            }
                        }
                    }
                    //костыль
                    if (errorBody != null || code in 400..499 || code in 500..526) {
                        callback.onResponse(
                            this@SWApiCall,
                            Response.success(ApiResponse.ApiError(errorBody, code))
                        )
                    } else {
                        callback.onResponse(
                            this@SWApiCall,
                            Response.success(ApiResponse.UnknownError(null))
                        )
                    }
                }
            }

            override fun onFailure(call: Call<TData>, t: Throwable) {
                val networkResponse = when (t) {
                    is IOException -> ApiResponse.NetworkError(t)
                    else -> ApiResponse.UnknownError(t)
                }
                callback.onResponse(this@SWApiCall, Response.success(networkResponse))
            }
        })
    }

    override fun isExecuted() = delegate.isExecuted
    override fun clone() = SWApiCall(delegate.clone(), errorConverter)
    override fun isCanceled() = delegate.isCanceled
    override fun cancel() = delegate.cancel()
    override fun request(): Request = delegate.request()
    override fun execute(): Response<ApiResponse<TData, TError>> {
        throw UnsupportedOperationException("SWApiCall doesn't support execute")
    }
}