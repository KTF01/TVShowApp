package com.example.tvshowapp


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.tvshowapp.database.AppDatabase
import org.junit.After
import org.junit.Before

abstract class DBMock {

    lateinit var db: AppDatabase
    @Before
    fun initDB() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDB() {
        db.close()
    }

}