package com.example.homework7.ui.viewmodel

import android.icu.text.CaseMap.Title
import androidx.lifecycle.ViewModel
import com.example.homework7.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TodoSaveViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {

    fun save(title: String, description: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.save(title, description)
        }
    }
}