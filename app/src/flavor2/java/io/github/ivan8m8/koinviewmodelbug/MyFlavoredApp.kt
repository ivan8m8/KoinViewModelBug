package io.github.ivan8m8.koinviewmodelbug

import org.koin.core.module.Module

class MyFlavoredApp : MyApp() {
    override val koinModules: MutableList<Module> = mutableListOf(MainModule.module, FlavoredModule.flavoredModule)
}