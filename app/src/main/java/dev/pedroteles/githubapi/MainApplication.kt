package dev.pedroteles.githubapi

import android.app.Application
import dev.pedroteles.githubapi.di.applicationModules
import dev.pedroteles.githubapi.di.dataModules
import dev.pedroteles.githubapi.di.coreModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(applicationModules, dataModules, coreModules)
        }
    }
}