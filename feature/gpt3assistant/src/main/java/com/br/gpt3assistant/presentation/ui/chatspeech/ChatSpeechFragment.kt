package com.br.gpt3assistant.presentation.ui.chatspeech

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.gpt3assistant.R
import com.br.gpt3assistant.databinding.FragmentChatSpeechBinding

class ChatSpeechFragment : Fragment() {

    private val binding by lazy { FragmentChatSpeechBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}