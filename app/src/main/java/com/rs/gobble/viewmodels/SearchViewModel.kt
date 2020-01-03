package com.rs.gobble.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rs.gobble.network.*
import com.rs.gobble.network.data.SearchResponse
import com.rs.gobble.repository.GobbleRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val gobbleRepository: GobbleRepository) :
    ViewModel() {

    val searchResponseLiveData: MutableLiveData<ResponseState<SearchResponse>> = MutableLiveData()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        onError(exception)
    }

    fun getSearchResponse(query: String) {

        searchResponseLiveData.value = Loading
        viewModelScope.launch(coroutineExceptionHandler) {
            searchResponseLiveData.value = Success(gobbleRepository.searchRecipes(query))
        }
    }

    private fun onError(throwable: Throwable) {
        searchResponseLiveData.value = NetworkError(throwable.message)
    }
}