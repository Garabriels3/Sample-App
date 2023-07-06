package com.br.presentation.baseviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel<STATE: UIState, ACTION: UIAction>(initialState: STATE) : ViewModel() {
    val state: StateFlow<STATE> get() = _state
    val action: LiveData<ACTION> get() = _action

    private val _state: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    private val _action: MutableLiveData<ACTION> = MutableLiveData()

    fun setState(state: (STATE) -> STATE) {
        _state.value = state.invoke(_state.value)
    }

    fun setAction(action: ACTION) {
        _action.value = action
    }
}