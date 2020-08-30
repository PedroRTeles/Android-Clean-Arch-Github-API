package dev.pedroteles.githubapi

import android.app.Application
import dev.pedroteles.githubapi.di.applicationModules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(applicationModules))
    }
}