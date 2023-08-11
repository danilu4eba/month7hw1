package com.example.month7hw1.data.base

import com.example.month7hw1.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {
   protected fun <T>makeRequest(coroutineRequest: suspend()-> T): Flow<Resource<T>> {
       return flow {
           emit(Resource.Loading())
           try {

               emit(Resource.Success(coroutineRequest))
           } catch (e: Exception) {
               emit(Resource.Error(e.localizedMessage as String))
           }
       }
    }
}