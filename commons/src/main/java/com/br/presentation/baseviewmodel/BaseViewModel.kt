package com.br.presentation.baseviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<STATE: UIState, ACTION: UIAction>(private val initialState: STATE) : ViewModel() {
    val state: LiveData<STATE> get() = _state
    val action: LiveData<ACTION> get() = _action

    private val _state: MutableLiveData<STATE> = MutableLiveData(initialState)
    private val _action: MutableLiveData<ACTION> = MutableLiveData()

    fun setState(state: (STATE) -> STATE) {
        _state.value = state.invoke(_state.value!!)
    }

    fun setAction(action: ACTION) {
        _action.value = action
    }
}