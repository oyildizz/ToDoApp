package com.example.todoapp

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getAppDB(context: Application): ToDoDatabase {
        return ToDoDatabase.getAppDB(context)
    }
    @Provides
    @Singleton
    fun toDoDao(appDB: ToDoDatabase): ToDoDao {
        return appDB.toDoDao()
    }
}