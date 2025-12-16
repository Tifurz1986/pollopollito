package com.example.pollopollito.di

import android.content.Context
import androidx.room.Room
import com.example.pollopollito.data.local.AppDatabase
import com.example.pollopollito.data.prefs.UserPrefs
import com.example.pollopollito.data.repository.ThawRepository

class AppContainer(context: Context) {

    private val database: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "thaw_db"
    ).build()

    private val thawDao = database.thawDao()

    val thawRepository = ThawRepository(thawDao)

    val userPrefs = UserPrefs(context)
}
