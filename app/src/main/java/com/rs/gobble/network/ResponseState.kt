package com.rs.gobble.network

sealed class ResponseState
data class NetworkError(val message: String?) : ResponseState()
object Loading : ResponseState()
data class Success(val data: Any) : ResponseState()