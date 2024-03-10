package com.example.homework7.data.repository

import com.example.homework7.data.datasource.TodoDataSource
import com.example.homework7.data.model.Todo

class TodoRepository(private val todoDataSource: TodoDataSource) {

    suspend fun save(title: String, description: String) =
        todoDataSource.save(title, description)
    suspend fun update(id: Int, title: String, description: String) =
        todoDataSource.update(id, title, description)
    suspend fun contactList(): List<Todo> =
        todoDataSource.todoList()
    suspend fun delete(id: Int) =
        todoDataSource.delete(id)
    suspend fun filterList(searchWord: String): List<Todo> =
        todoDataSource.filterList(searchWord)
}