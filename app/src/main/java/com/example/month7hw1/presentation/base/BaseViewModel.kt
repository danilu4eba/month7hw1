package com.example.month7hw1.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.month7hw1.data.db.models.WayEntity
import com.example.month7hw1.domain.util.Resource
import com.example.month7hw1.presentation.ui.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {
    protected fun <T> Flow<Resource<T>>.collectData(

        _state: StateFlow<UiState<List<WayEntity>>>

    ) {
        viewModelScope.launch {
            this@collectData.collect {
                when (it) {
                    is Resource.Error -> {
                        _state.value = UiState.Error((it.message ?: "error").toString())

                    }

                    is Resource.Loading -> {
                        _state.value = UiState.Loading()

                    }

                    is Resource.Success -> {
                        if (it.data != null) {
                            _state.value = UiState.Success(it.data)
                        } else {
                            println("empty")
                        }
                    }
                }
            }
        }
    }
}