package com.br.gpt3assistant.presentation.ui.chatspeech

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.asLiveData
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.br.gpt3assistant.databinding.FragmentChatSpeechBinding
import com.br.presentation.baseview.BaseFragment
import java.util.*

private const val REQUEST_RECORD_AUDIO_PERMISSION = 200

class ChatSpeechFragment : BaseFragment<ChatSpeechState, ChatSpeechAction>() {

    private val binding by lazy { FragmentChatSpeechBinding.inflate(layoutInflater) }
    override val viewModel: ChatSpeechViewModel by viewModel()

    override fun onViewSetup(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        requestAudioPermission()
    }

    override fun onStateListener(state: ChatSpeechState) {
        when {
            state.isLoading -> {
                binding.pbLoading.visibility = View.VISIBLE
                binding.tvIAResponse.visibility = View.GONE
            }
            state.error != null -> {
                binding.pbLoading.visibility = View.GONE
                binding.tvCanSpeakIndicator.text = state.error
                binding.btnRecording.isEnabled = true
            }
            state.isReadyForListen -> {
                binding.pbLoading.visibility = View.GONE
                binding.tvCanSpeakIndicator.text = "Ouvindo..."
                binding.btnRecording.isEnabled = false
            }
            state.convertedText != null -> {
                binding.pbLoading.visibility = View.GONE
                binding.tvIAResponse.visibility = View.VISIBLE
                binding.btnRecording.isEnabled = true
                binding.tvCanSpeakIndicator.text = "Pressione e pergunte"
                binding.tvIAResponse.text = state.convertedText
            }
        }
    }

    override fun onActionListener(action: ChatSpeechAction) {
        when (action) {
            is ChatSpeechAction.SpeechEnabled -> {
                viewModel.recordAudio()
            }
        }
    }

    private fun requestAudioPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.RECORD_AUDIO),
                REQUEST_RECORD_AUDIO_PERMISSION
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun buttonListener() {
        binding.btnRecording.setOnClickListener {
            viewModel.onSpeechRecordingAction()
        }
    }
}