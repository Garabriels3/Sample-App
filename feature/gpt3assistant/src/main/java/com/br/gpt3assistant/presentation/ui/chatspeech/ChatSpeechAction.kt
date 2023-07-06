package com.br.gpt3assistant.presentation.ui.chatspeech

import com.br.presentation.baseviewmodel.UIAction

sealed class ChatSpeechAction : UIAction {
    object SpeechEnabled : ChatSpeechAction()
}