package io.office

import android.app.Application
import io.office.di.AppComponent
import io.office.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {

        lateinit var INSTANCE: App
        lateinit var appComponent: AppComponent
    }
}