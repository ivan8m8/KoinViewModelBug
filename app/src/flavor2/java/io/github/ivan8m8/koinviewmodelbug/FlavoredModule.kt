package io.github.ivan8m8.koinviewmodelbug

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

object FlavoredModule {
    val flavoredModule = module {
        viewModel<MyViewModel>(named(Constants.MY_VIEW_MODEL), override = true) { (param: String) ->
            MyFlavoredViewModel(param)
        }
    }
}