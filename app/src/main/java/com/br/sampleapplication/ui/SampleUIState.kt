package com.br.sampleapplication.ui

import com.br.sampleapplication.baseviewmodel.UIState

data class SampleUIState(
    val data: String = "",
    val onError: String = "",
    val onLoading: Boolean = false
) : UIState {
    fun setSuccessState(value: String): SampleUIState {
        return this.copy(data = value, onError = "", onLoading = false)
    }

    fun setErrorState(value: String): SampleUIState {
        return this.copy(data = "", onError = value, onLoading = false)
    }
}
