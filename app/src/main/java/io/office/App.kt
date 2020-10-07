package io.office

import android.app.Application
import android.content.res.Configuration

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {

        lateinit var INSTANCE: App
    }
}