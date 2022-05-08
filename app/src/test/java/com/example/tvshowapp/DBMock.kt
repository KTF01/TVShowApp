package com.example.tvshowapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.tvshowapp.database.AppDatabase
import org.junit.Before
import org.junit.After
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class DBMock {
    lateinit var db: AppDatabase

    @Before
    fun initDB() {
        db = Room.inMemoryDatabaseBuilder(getApplicationContext(), AppDatabase::class.java)
           .allowMainThreadQueries().build()
    }

    @After
    fun closeDB() {
        db.close()
    }
}