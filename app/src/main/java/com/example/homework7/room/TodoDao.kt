package com.example.homework7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.homework7.data.model.Todo
@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    suspend fun getTodoList(): List<Todo>

    @Insert
    suspend fun save(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

    @Query("SELECT * FROM todos WHERE title like '%' || :searchWord || '%'")
    suspend fun search(searchWord: String): List<Todo>
}