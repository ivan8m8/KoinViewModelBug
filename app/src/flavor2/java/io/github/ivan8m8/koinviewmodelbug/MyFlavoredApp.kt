package io.github.ivan8m8.koinviewmodelbug

import io.github.ivan8m8.koinviewmodelbug.dagger.AppComponent
import io.github.ivan8m8.koinviewmodelbug.dagger.DaggerFlavoredAppComponent

class MyFlavoredApp : MyApp() {

    override fun initAppComponent(): AppComponent {
        return DaggerFlavoredAppComponent.create()
    }
}