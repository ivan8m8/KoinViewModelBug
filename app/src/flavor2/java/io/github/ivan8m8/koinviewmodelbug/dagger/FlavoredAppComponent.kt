package io.github.ivan8m8.koinviewmodelbug.dagger

import dagger.Component
import io.github.ivan8m8.koinviewmodelbug.FlavoredFragment
import io.github.ivan8m8.koinviewmodelbug.MyFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MyFlavoredModule::class
    ]
)
interface FlavoredAppComponent : AppComponent {
    override fun inject(myFragment: MyFragment)
    fun inject(flavoredFragment: FlavoredFragment)
}