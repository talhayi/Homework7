package com.example.homework7.data.datasource

import com.example.homework7.data.model.Todo
import com.example.homework7.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(private var todoDao: TodoDao) {

    suspend fun todoList(): List<Todo> =
        withContext(Dispatchers.IO){
            return@withContext todoDao.getTodoList()
        }

    suspend fun save(title: String, description: String){
        val todos = Todo(0, title, description)
        todoDao.save(todos)
    }

    suspend fun update(id: Int, title: String, description: String){
        val todos = Todo(id, title, description)
        todoDao.update(todos)
    }
    suspend fun delete(id: Int){
        val todos = Todo(id, "", "")
        todoDao.delete(todos)
    }

    suspend fun filterList(searchWord: String): List<Todo> =
        withContext(Dispatchers.IO){
            return@withContext todoDao.search(searchWord)
        }
}