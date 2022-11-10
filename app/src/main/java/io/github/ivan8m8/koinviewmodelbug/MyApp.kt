package io.github.ivan8m8.koinviewmodelbug

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        println("MY_TAG App init $this")
    }
}