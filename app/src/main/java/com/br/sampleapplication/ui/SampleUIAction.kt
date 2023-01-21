package com.br.sampleapplication.ui

import com.br.sampleapplication.baseviewmodel.UIAction

sealed class SampleUIAction : UIAction {
    object OpenNextScreen: SampleUIAction()
}
