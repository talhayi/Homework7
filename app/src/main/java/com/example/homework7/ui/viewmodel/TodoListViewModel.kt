package com.example.homework7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework7.data.model.Todo
import com.example.homework7.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {

    val todoList = MutableLiveData<List<Todo>>()
    init {
        todoList()
    }

    fun todoList(){
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoRepository.contactList()
        }
    }
    fun delete(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.delete(id)
            todoList()
        }
    }
    fun filterList(searchWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoRepository.filterList(searchWord)
        }
    }
}