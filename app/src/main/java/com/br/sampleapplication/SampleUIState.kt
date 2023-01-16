package com.br.sampleapplication

import com.br.sampleapplication.baseviewmodel.UIState

data class SampleUIState(
    val data: String? = "",
    val onError: String? = "",
    val onLoading: Boolean? = false
) : UIState {
    fun setSuccessState(value: String): SampleUIState {
        return this.copy(data = value, onError = null, onLoading = false)
    }

    fun setErrorState(value: String): SampleUIState {
        return this.copy(data = null, onError = value, onLoading = false)
    }
}
