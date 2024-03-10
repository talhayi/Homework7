package com.example.homework7.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework7.databinding.FragmentTodoSaveBinding
import com.example.homework7.ui.viewmodel.TodoSaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoSaveFragment : Fragment() {

    private lateinit var binding: FragmentTodoSaveBinding
    private val viewModel: TodoSaveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoSaveBinding.inflate(inflater, container, false)
        onSaveButton()
        return binding.root
    }

    private fun onSaveButton(){
        binding.buttonSave.setOnClickListener {
            val title = binding.editTextSaveTitle.text.toString()
            val description = binding.editTextSaveDescription.text.toString()
            viewModel.save(title, description)
        }
    }
}