package com.br.gpt3assistant.presentation.ui.chatspeech

import androidx.lifecycle.viewModelScope
import com.br.gpt3assistant.data.datasource.remote.ChatGptAssistantRemoteDataSource
import com.br.gpt3assistant.data.request.GptRequest
import com.br.gpt3assistant.presentation.audioconverter.SpeechRecognitionService
import com.br.presentation.baseviewmodel.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ChatSpeechViewModel constructor(
    private val speechRecognitionService: SpeechRecognitionService,
    private val chatGptAssistantRemoteDataSource: ChatGptAssistantRemoteDataSource
) : BaseViewModel<ChatSpeechState, ChatSpeechAction>(ChatSpeechState()) {

    private val conversation = mutableListOf<Message>()

    fun recordAudio() {
        viewModelScope.launch {
            speechRecognitionService.startListening {
                setState { state -> state.onSpeechEnabled() }
            }
                .catch {
                    setState { state -> state.onError("Ops, tente de novo") }
                }
                .collect {
                    addMessage("Usuário", "\nOlá, meu nome é Anselmo. $it")
                    sendToChatGptAssistant()
                }
        }
    }

    private fun addMessage(sender: String, content: String) {
        conversation.add(Message(sender, content))
    }

    private fun buildPrompt(): String {
        return conversation.joinToString(separator = "\n") { "${it.sender}: ${it.content}" }
    }

    private fun sendToChatGptAssistant() {
        val gptRequest = GptRequest(prompt = buildPrompt())
        viewModelScope.launch {
            chatGptAssistantRemoteDataSource.getChatGptAssistantResponse(gptRequest)
                .onStart { setState { state -> state.onLoading() } }
                .catch {
                    setState { state -> state.onError("Ops, tente de novo") }
                }
                .collect {
                    addMessage("IA", it.choices.first().text)
                    setState { state -> state.onConvertedText(it.choices.first().text.removePrefix("IA:").trim()) }
                }
        }
    }

    fun onSpeechRecordingAction() {
        setAction(ChatSpeechAction.SpeechEnabled)
    }
}

data class Message(val sender: String, val content: String)
