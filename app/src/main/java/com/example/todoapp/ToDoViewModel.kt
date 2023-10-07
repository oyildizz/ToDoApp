package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(var repository: ToDoRepository) : ViewModel() {
    var allToDoItems: LiveData<List<ToDoItem>> = repository.getAllToDoItems()

    init {
    }

//    fun getAllToDoItems() {
//        allToDoItems.postValue()
//    }

    fun insertToDoItem(item: ToDoItem) {
        repository.insertToDoItem(item)
    }

    fun updateToDoItem(item: ToDoItem) {
        repository.updateToDoItem(item)
    }

    fun deleteToDoItem(id:Int) {
        repository.deleteToDoItem(id)
    }
}