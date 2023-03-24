package com.br.presentation.baseview

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.br.presentation.baseviewmodel.UIAction
import com.br.presentation.baseviewmodel.UIState

abstract class BaseFragment<State : UIState, Action : UIAction> : Fragment() {

    fun onStartObservers(state: LiveData<State>, action: LiveData<Action>) {
        state.observe(viewLifecycleOwner) {
            onStateListener(it)
        }
        action.observe(viewLifecycleOwner) {
            onActionListener(it)
        }
    }

    abstract fun onStateListener(state: State)

    abstract fun onActionListener(action: Action)
}