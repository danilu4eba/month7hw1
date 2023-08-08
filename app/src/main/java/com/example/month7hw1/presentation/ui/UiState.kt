package com.example.month7hw1.presentation.ui

sealed class UiState<T> {
    class Loading<T>: UiState<T>()
    class Success<T>(val data : T): UiState<T>()
    class Error<T>(val message:String):UiState<T>()
    class Empty<T>: UiState<T>()

}