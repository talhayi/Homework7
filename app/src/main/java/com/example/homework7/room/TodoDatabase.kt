package com.example.homework7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework7.data.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun getTodoDao(): TodoDao
}