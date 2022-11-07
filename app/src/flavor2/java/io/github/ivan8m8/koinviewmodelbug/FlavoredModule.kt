package io.github.ivan8m8.koinviewmodelbug

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

object FlavoredModule {
    val flavoredModule = module {
        viewModel(named(Constants.MY_VIEW_MODEL)) { params ->
            MyFlavoredViewModel(params.get())
        } bind MyViewModel::class
    }
}