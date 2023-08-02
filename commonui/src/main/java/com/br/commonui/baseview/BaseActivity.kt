package com.br.commonui.baseview

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.br.commonui.baseviewmodel.UIAction
import com.br.commonui.baseviewmodel.UIState

abstract class BaseActivity<State : UIState, Action : UIAction> : AppCompatActivity() {

    fun onStartActivity(state: LiveData<State>, action: LiveData<Action>) {
        state.observe(this) {
            onStateListener(it)
        }
        action.observe(this) {
            onActionListener(it)
        }
    }

    abstract fun onStateListener(state: State)

    abstract fun onActionListener(action: Action)
}