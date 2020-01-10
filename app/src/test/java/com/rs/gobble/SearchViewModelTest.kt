package com.rs.gobble

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import com.rs.gobble.network.GobbleApi
import com.rs.gobble.network.Loading
import com.rs.gobble.network.Success
import com.rs.gobble.network.data.SearchResponse
import com.rs.gobble.repository.GobbleRepository
import com.rs.gobble.util.LiveDataTestUtil
import com.rs.gobble.util.MainCoroutineRule
import com.rs.gobble.util.TestUtil
import com.rs.gobble.viewmodels.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class SearchViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var gobbleApi: GobbleApi

    @Mock
    private lateinit var gobbleRepository: GobbleRepository

    @InjectMocks
    private lateinit var searchViewModel: SearchViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetSearchResponse() {

        mainCoroutineRule.runBlockingTest {
            given(
                gobbleApi.searchRecipes(
                    "fakeText",
                    0,
                    10
                )
            ).willReturn(TestUtil.getFakeSearchEmptyResponse())
            given(gobbleRepository.searchRecipes("fakeText")).willReturn(TestUtil.getFakeSearchEmptyResponse())

            mainCoroutineRule.pauseDispatcher()

            searchViewModel.getSearchResponse("fakeText")

            assertEquals(LiveDataTestUtil.getValue(searchViewModel.searchResponseLiveData), Loading)

            mainCoroutineRule.resumeDispatcher()

            println(searchViewModel.searchResponseLiveData.value)

            val responseState = LiveDataTestUtil.getValue(searchViewModel.searchResponseLiveData)
            assertTrue(responseState is Success<SearchResponse>)

            val data = (responseState as Success).data

            assertNotNull(data)
            assertTrue(data.results.isEmpty())
            assertTrue(data.baseUri.isEmpty())
        }
    }
}