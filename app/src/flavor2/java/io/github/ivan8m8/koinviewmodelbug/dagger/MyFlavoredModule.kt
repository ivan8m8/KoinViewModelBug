package io.github.ivan8m8.koinviewmodelbug.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.ivan8m8.koinviewmodelbug.MyFlavoredViewModel
import io.github.ivan8m8.koinviewmodelbug.MyViewModel

@Module
abstract class MyFlavoredModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(myFlavoredViewModel: MyFlavoredViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyFlavoredViewModel::class)
    abstract fun myFlavoredViewModel(myFlavoredViewModel: MyFlavoredViewModel): ViewModel
}