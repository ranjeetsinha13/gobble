package com.rs.gobble.util

import com.rs.gobble.network.data.SearchResponse

object TestUtil {

    fun getFakeSearchEmptyResponse(): SearchResponse {
        return SearchResponse(emptyList(), "")
    }
}