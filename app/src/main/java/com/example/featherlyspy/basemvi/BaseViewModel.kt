package com.example.featherlyspy.basemvi

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<S : MviState, in A : MviAction>(
    initialState: S
) : ViewModel() {

    private val tag: String? = this::class.simpleName

    private val _uiState: MutableStateFlow<S> = MutableStateFlow(initialState)
    val uiState: StateFlow<S>
        get() = _uiState

    init {
        Log.d(tag, "mvi-log-init")
    }

    fun receiveAction(action: A) {
        Log.d(tag, "mvi-log-action $action")
        reduce(_uiState.value, action)
    }

    fun setState(newState: S) {
        Log.d(tag, "mvi-log-state $newState")
        _uiState.tryEmit(newState)
    }

    abstract fun reduce(oldState: S, action: A)

}
