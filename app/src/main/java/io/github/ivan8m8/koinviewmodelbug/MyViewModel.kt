package io.github.ivan8m8.koinviewmodelbug

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

open class MyViewModel @Inject constructor
    ()
    : ViewModel() {

    val liveData = MutableLiveData<String>()

    init {
        println("MY_TAG VM init $this")
        liveData.value = "Flavor2"
        //liveData.value = savedStateHandle.get<String>("key")!!.toString() + "!"
    }
}