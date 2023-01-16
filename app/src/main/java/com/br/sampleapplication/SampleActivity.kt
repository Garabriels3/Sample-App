package com.br.sampleapplication

import android.os.Bundle
import com.br.sampleapplication.baseview.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SampleActivity :
    BaseActivity<SampleUIState, SampleUIAction>() {

    private val sampleViewModel: SampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onStartActivity(sampleViewModel.state, sampleViewModel.action)
    }

    override fun onStateListener(state: SampleUIState) {
    }

    override fun onActionListener(action: SampleUIAction) {
    }
}