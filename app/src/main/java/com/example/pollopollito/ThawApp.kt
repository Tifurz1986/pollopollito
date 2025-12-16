package com.example.pollopollito

import android.app.Application
import com.example.pollopollito.di.AppContainer

class PollopollitoApp : Application() {

    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
