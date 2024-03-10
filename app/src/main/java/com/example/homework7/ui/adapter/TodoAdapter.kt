package com.example.homework7.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.data.model.Todo
import com.example.homework7.databinding.TodoItemListBinding
import com.example.homework7.ui.view.TodoListFragmentDirections
import com.example.homework7.ui.viewmodel.TodoListViewModel
import com.example.homework7.util.actions


class TodoAdapter (private var todoList: List<Todo>, var viewModel: TodoListViewModel): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(var binding: TodoItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todos = todoList[position]
        holder.binding.title.text = todos.title
        holder.binding.description.apply {
            text = if (todos.description.length > 120){
                "${todos.description.substring(0,120)}..."
            }else{
                todos.description
            }
        }
        holder.binding.todoItemLayout.setOnClickListener {
            val actions = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailFragment(todos)
            Navigation.actions(it, actions)
        }

        holder.binding.delete.setOnClickListener {
            viewModel.delete(todos.id)
        }
    }
}