package io.github.ivan8m8.koinviewmodelbug.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println("MY_TAG creating view model for $modelClass")
        val vm = viewModels[modelClass]?.get() as T
        println("MY_TAG created view model $vm")
        return vm
    }
}