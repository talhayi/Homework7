package com.example.homework7.di

import android.content.Context
import androidx.room.Room
import com.example.homework7.data.datasource.TodoDataSource
import com.example.homework7.data.repository.TodoRepository
import com.example.homework7.room.TodoDao
import com.example.homework7.room.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoDataSource(todoDao: TodoDao): TodoDataSource {
        return TodoDataSource(todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoDataSource: TodoDataSource): TodoRepository {
        return TodoRepository(todoDataSource)
    }

    @Provides
    @Singleton
    fun provideContactDao(@ApplicationContext context: Context): TodoDao {
        val db = Room.databaseBuilder(context, TodoDatabase::class.java, "todoDatabase").build()
        return db.getTodoDao()
    }
}
