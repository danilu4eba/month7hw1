package com.example.month7hw1.presentation

import com.example.month7hw1.data.db.models.WayEntity
import com.example.month7hw1.domain.useCases.CreateWayUseCase
import com.example.month7hw1.domain.useCases.DeleteWayUseCase
import com.example.month7hw1.domain.useCases.GetWayUseCase
import com.example.month7hw1.domain.useCases.UpdateUseCase
import com.example.month7hw1.presentation.base.BaseViewModel
import com.example.month7hw1.presentation.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WayViewModel @Inject constructor(

    private val getWayUseCase: GetWayUseCase,
    private val createWayUseCase: CreateWayUseCase,
    private val updateUseCase: UpdateUseCase,
    private val deleteWayUseCase: DeleteWayUseCase
    ) : BaseViewModel() {

    private val _mutableStateFlowForGet = MutableStateFlow<UiState<List<WayEntity>>>(UiState.Empty())
    val getAllWay: StateFlow<UiState<List<WayEntity>>> = _mutableStateFlowForGet

    private val _mutableStateFlowForCreate = MutableStateFlow<UiState<List<WayEntity>>>(UiState.Empty())
    val createWay: StateFlow<UiState<List<WayEntity>>> = _mutableStateFlowForCreate

    suspend fun getAll() {
        getWayUseCase.getWay().collectData(_mutableStateFlowForGet )
    }

    suspend fun createWay(way: WayEntity){
        createWayUseCase.createWay(way).collectData(createWay)
    }
    suspend fun deleteWay(way:WayEntity){
        deleteWayUseCase.deleteWay(way)
    }

    suspend fun updateWay(way:WayEntity){
        updateUseCase.updateWay(way)
    }
}