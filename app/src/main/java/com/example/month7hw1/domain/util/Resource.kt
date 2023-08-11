package com.example.month7hw1.domain.util

sealed class Resource<T>
    (
    val data: T? = null,
    val message: T? = null,
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: suspend () -> T) : Resource<T>()
    class Error<T>(message: String, data: T? = null) : Resource<T>()
}