package com.example.homework7.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.homework7.R
import com.example.homework7.databinding.FragmentTodoListBinding
import com.example.homework7.ui.adapter.TodoAdapter
import com.example.homework7.ui.viewmodel.TodoListViewModel
import com.example.homework7.util.actions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment() {

    private lateinit var binding: FragmentTodoListBinding
    private val viewModel: TodoListViewModel by viewModels()
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)

        viewModel.todoList.observe(viewLifecycleOwner) { todoList ->
            todoAdapter = TodoAdapter(todoList, viewModel)
            binding.recyclerViewTodo.adapter = todoAdapter
            binding.recyclerViewTodo.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        }
        search()
        onSaveButton()
        return binding.root
    }

    private fun onSaveButton() {
        binding.floatingActionButton.setOnClickListener {
            Navigation.actions(it, R.id.action_todoListFragment_to_todoSaveFragment)
        }
    }

    private fun search() {
        binding.searchViewTodoList.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                p0?.let {
                    viewModel.filterList(it)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                p0?.let {
                    viewModel.filterList(it)
                }
                return true
            }
        }
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.todoList()
    }
}