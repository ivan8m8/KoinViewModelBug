package io.github.ivan8m8.koinviewmodelbug

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MyViewModel(
    private val param: String
) : ViewModel() {

    val liveData = MutableLiveData<String>()

    init {
        println("MY_TAG init $this")
        liveData.value = param
    }
}