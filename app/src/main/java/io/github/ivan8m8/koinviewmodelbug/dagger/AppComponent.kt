package io.github.ivan8m8.koinviewmodelbug.dagger

import dagger.Component
import io.github.ivan8m8.koinviewmodelbug.MyFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MyModule::class
    ]
)
interface AppComponent {
    fun inject(myFragment: MyFragment)
}