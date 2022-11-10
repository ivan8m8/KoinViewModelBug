package io.github.ivan8m8.koinviewmodelbug

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class MyViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val liveData = MutableLiveData<String>()

    init {
        println("MY_TAG MyViewModel init $this")
        liveData.value = savedStateHandle.get<String>("key")!!.toString() + "!"
    }
}