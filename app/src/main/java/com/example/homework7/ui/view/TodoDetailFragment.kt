package com.example.homework7.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homework7.databinding.FragmentTodoDetailBinding
import com.example.homework7.ui.viewmodel.TodoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoDetailFragment : Fragment() {

    private lateinit var binding: FragmentTodoDetailBinding
    private val viewModel: TodoDetailViewModel by viewModels()
    private val bundle: TodoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoDetailBinding.inflate(inflater, container, false)
        binding.editTextUpdateTitle.setText(bundle.todo.title)
        binding.editTextUpdateDescription.setText(bundle.todo.description)
        binding.buttonUpdate.setOnClickListener{
            val id = bundle.todo.id
            val title = binding.editTextUpdateTitle.text.toString()
            val description = binding.editTextUpdateDescription.text.toString()
            viewModel.update(id, title, description)
        }
        return binding.root
    }
}