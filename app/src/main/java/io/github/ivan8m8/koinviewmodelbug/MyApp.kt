package io.github.ivan8m8.koinviewmodelbug

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class MyApp : Application() {

    protected open val koinModules = mutableListOf(MainModule.module)

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(koinModules)
        }
    }
}