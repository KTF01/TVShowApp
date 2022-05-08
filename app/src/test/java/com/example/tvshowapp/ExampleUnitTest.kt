package com.example.tvshowapp
import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tvshowapp.database.TVShowDAO
import com.example.tvshowapp.model.TVShow
import com.example.tvshowapp.network.TVMazeAPIMock
import com.example.tvshowapp.network.TvShowType
import com.example.tvshowapp.repository.TVShowApiRepository
import com.example.tvshowapp.ui.detail.DetailViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.mockk.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest : DBMock() {
    private lateinit var showDAO: TVShowDAO

    @Before
    fun set_up_db(){
        showDAO = db.tvShowDao()
    }

    /*@Test
    fun genreListIsCorrect() {
        val vm:DetailViewModel = DetailViewModel(Application())
        val testGenres = listOf("Drama", "Comedy")
        val testTVShow = TvShowType(1, "Test Name", "Scripted", "English", emptyList(), "", null, "")
        assertEquals(vm.getGenresString(testTVShow), "Drama, Comedy")
    }*/

    @Test
    fun repository_test() = runBlocking{
        val testGenres = listOf("Drama", "Comedy")
        val testTVShow = TVShow(1, "Test Name", "Scripted", "English", "","",emptyList(), null)
        showDAO.insertShow(testTVShow)
        assertEquals(showDAO.getFavourites().size,1)

        showDAO.deleteShow(testTVShow)
        assertEquals(showDAO.getFavourites().size, 0)
    }



}