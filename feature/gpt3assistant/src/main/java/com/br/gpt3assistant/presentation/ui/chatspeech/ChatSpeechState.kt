package com.br.gpt3assistant.presentation.ui.chatspeech

import com.br.presentation.baseviewmodel.UIState

data class ChatSpeechState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val isReadyForListen: Boolean = false,
    val convertedText: String? = null,
) : UIState {
    fun onSpeechEnabled() = copy(isReadyForListen = true, isLoading = false, error = null, convertedText = "")
    fun onConvertedText(text: String) = copy(convertedText = text, isLoading = false, error = null)
    fun onLoading() = copy(isLoading = true, error = null, isReadyForListen = false, convertedText = "")
    fun onError(error: String) = copy(error = error, isLoading = false, isReadyForListen = false, convertedText = "")
}