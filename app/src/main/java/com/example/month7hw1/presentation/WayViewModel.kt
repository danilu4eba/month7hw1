package com.example.month7hw1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.month7hw1.data.db.models.WayEntity
import com.example.month7hw1.domain.useCases.GetWayUseCase
import com.example.month7hw1.domain.util.Resource
import com.example.month7hw1.presentation.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WayViewModel @Inject constructor(private val getWayUseCase: GetWayUseCase) : ViewModel() {

    private val _mutableStateFlow = MutableStateFlow<UiState<List<WayEntity>>>(UiState.Empty())
    val getAllWay: StateFlow<UiState<List<WayEntity>>> = _mutableStateFlow

    fun getAll() {
        viewModelScope.launch {
            getWayUseCase.getWay().collect() {
                when (it) {
                    is Resource.Error -> {
                        _mutableStateFlow.value =
                            UiState.Error((it.message ?: "some error").toString())
                    }

                    is Resource.Success -> {
                        _mutableStateFlow.value = UiState.Loading()
                    }

                    is Resource.Loading -> {
                        if (it.data != null) {
                            _mutableStateFlow.value = UiState.Success(it.data)
                        }

                    }
                }
            }
        }
    }
}