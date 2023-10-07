package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_items")
    fun getAllToDoItems(): LiveData<List<ToDoItem>>

    @Insert
    fun insertToDoItem(item: ToDoItem)

    @Update
    fun updateToDoItem(item: ToDoItem)

    @Query("DELETE FROM todo_items WHERE id = :id")
    fun deleteToDoItem(id:Int)
}