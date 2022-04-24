package com.example.tvshowapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tvshowapp.model.Genre
import com.example.tvshowapp.model.TVShow

@Database(entities = [TVShow::class, Genre::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tvShowDao(): TVShowDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "tvShows.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}