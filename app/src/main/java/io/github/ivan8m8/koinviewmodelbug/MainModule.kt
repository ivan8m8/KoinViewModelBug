package io.github.ivan8m8.koinviewmodelbug

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object MainModule {

    val module = module {
        viewModel(named(Constants.MY_VIEW_MODEL)) { params ->
            MyViewModel(params.get())
        }
    }
}