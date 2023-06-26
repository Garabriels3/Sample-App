package com.br.presentation.baseview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.br.presentation.baseviewmodel.BaseViewModel
import com.br.presentation.baseviewmodel.UIAction
import com.br.presentation.baseviewmodel.UIState

abstract class BaseFragment<State : UIState, Action : UIAction> : Fragment() {

    abstract val viewModel: BaseViewModel<State, Action>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onStartObservers(state = viewModel.state.asLiveData(), action = viewModel.action)
        onViewSetup(view, savedInstanceState)
    }

    abstract fun onViewSetup(view: View, savedInstanceState: Bundle?)

    private fun onStartObservers(state: LiveData<State>, action: LiveData<Action>) {
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