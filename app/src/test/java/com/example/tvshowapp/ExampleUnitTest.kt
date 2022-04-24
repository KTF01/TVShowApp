package com.example.tvshowapp

import androidx.lifecycle.LiveData
import com.example.tvshowapp.database.TVShowDAO
import com.example.tvshowapp.model.ShowWithGenres
import com.example.tvshowapp.repository.TVShowRepository
import io.mockk.every
import io.mockk.mockk
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}