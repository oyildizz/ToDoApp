package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo_items")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int ,
    val title: String,
    val description: String,
    val completed: Boolean = false
) : Serializable {}
