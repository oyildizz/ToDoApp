package com.example.todoapp

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    fun getAllToDoItems():LiveData<List<ToDoItem>> =  toDoDao.getAllToDoItems()

    fun insertToDoItem(item: ToDoItem) {
        toDoDao.insertToDoItem(item)
    }

    fun updateToDoItem(item: ToDoItem) {
        toDoDao.updateToDoItem(item)
    }

    fun deleteToDoItem(id:Int) {
        toDoDao.deleteToDoItem(id)
    }
}