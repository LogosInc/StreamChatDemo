package com.example.streamchatdemo.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.streamchatdemo.databinding.FragmentLoginBinding
import com.example.streamchatdemo.model.ChatUser
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            authenticationTheUser()
        }

        return binding.root
    }

    private fun authenticationTheUser() {
        val firstName = binding.firstNameEditText.text.toString()
        val userName = binding.usernameEditText.text.toString()
        if (validateInput(firstName, binding.firstNameInputLayout) &&
            validateInput(userName, binding.usernameInputLayout)
        ) {
            val chatUser = ChatUser(firstName, userName)
            val action = LoginFragmentDirections.actionLoginFragmentToChannelFragment(chatUser)
            findNavController().navigate(action)
        }
    }

    private fun validateInput(inputText: String, textInputLayout: TextInputLayout): Boolean {
        return if (inputText.length <= 3) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "* Minimum 4 characters Allowed"
            false
        } else {
            textInputLayout.isErrorEnabled = false
            textInputLayout.error = null
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}