package com.rs.gobble.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rs.gobble.network.GobbleApi
import com.rs.gobble.network.ResponseState
import com.rs.gobble.network.Success
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val gobbleApi: GobbleApi) : ViewModel() {

    private val searchResponseLiveData: MutableLiveData<ResponseState> = MutableLiveData()

    fun getSearchResponse(query: String) {

        viewModelScope.launch {
            gobbleApi.searchRecipes(query)

            searchResponseLiveData.value = Success(gobbleApi.searchRecipes(query))
        }
    }
}