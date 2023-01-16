package com.br.sampleapplication

import com.br.sampleapplication.baseviewmodel.UIAction

sealed class SampleUIAction : UIAction {
    object OpenNextScreen: SampleUIAction()
}
