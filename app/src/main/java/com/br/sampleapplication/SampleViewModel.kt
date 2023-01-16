package com.br.sampleapplication

import com.br.sampleapplication.baseviewmodel.BaseViewModel

class SampleViewModel : BaseViewModel<SampleUIState, SampleUIAction>(SampleUIState(onLoading = true)) {

    fun getData() {
        val success = "Gabriel"
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