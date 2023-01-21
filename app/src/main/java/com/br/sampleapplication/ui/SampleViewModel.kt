package com.br.sampleapplication.ui

import androidx.lifecycle.viewModelScope
import com.br.sampleapplication.baseviewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SampleViewModel : BaseViewModel<SampleUIState, SampleUIAction>(SampleUIState(onLoading = true)) {

    fun getData() {
        val success = "aaaa"
        viewModelScope.launch {
            delay(3000)
            if (success.isNotEmpty()) {
                setState {
                    it.setSuccessState("Gabriel")
                }
            } else {
                setState {
                    it.setErrorState("Deu ruim")
                }
            }
        }
    }

    fun setReadTextInputState(text: String) {
        setState {
            it.setSuccessState(text)
        }
    }
}