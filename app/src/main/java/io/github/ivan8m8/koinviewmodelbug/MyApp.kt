package io.github.ivan8m8.koinviewmodelbug

import android.app.Application
import io.github.ivan8m8.koinviewmodelbug.dagger.AppComponent
import io.github.ivan8m8.koinviewmodelbug.dagger.DaggerAppComponent

open class MyApp : Application() {

    val appComponent: AppComponent by lazy {
        initAppComponent()
    }

    override fun onCreate() {
        super.onCreate()
        println("MY_TAG App init $this")
    }

    protected open fun initAppComponent(): AppComponent {
        return DaggerAppComponent.create()
    }
}