package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val toDoViewModel by lazy {
        ViewModelProvider(
            this,
            defaultViewModelProviderFactory
        )[ToDoViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonAdd = binding.buttonAdd
        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)

        // LiveData ile veri güncellemelerini izle
        toDoViewModel.allToDoItems.observe(this,  Observer {toDoItems ->
           // Veri güncellendiğinde RecyclerView'e yeniden yükle
            val toDoAdapter=ToDoAdapter(this,toDoItems,toDoViewModel)
            recyclerView.adapter = toDoAdapter
        })

        buttonAdd.setOnClickListener {
            addNewToDoItem()
            toDoViewModel.allToDoItems
        }
    }

    private fun addNewToDoItem() {
        val title = binding.editTextTitle.text.toString()
        val description = binding.editTextDescription.text.toString()
        var id :Int =0
        if (title.isNotEmpty() && description.isNotEmpty()) {
            val newToDoItem = ToDoItem(title = title, description = description, id = id)
            toDoViewModel.insertToDoItem(newToDoItem)
            // Girdileri temizle
            binding.editTextTitle.text.clear()
            binding.editTextDescription.text.clear()
        }
    }

}