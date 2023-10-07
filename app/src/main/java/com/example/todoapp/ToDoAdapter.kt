package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ListItemLayoutBinding
import com.google.android.material.snackbar.Snackbar


class ToDoAdapter(var mContext: Context, var todoList: List<ToDoItem>, var viewModel: ToDoViewModel) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(var tasarim:ListItemLayoutBinding) : RecyclerView.ViewHolder(tasarim.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ToDoViewHolder {
        val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(mContext), parent, false)
         return ToDoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentToDoItem = todoList.get(position)
        val t = holder.tasarim

        t.textViewTitle.text = currentToDoItem.title
        t.textViewDescription.text=currentToDoItem.description

        t.buttonDelete.setOnClickListener{
            Snackbar.make(it,"${currentToDoItem.title} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    sil(currentToDoItem.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun sil(id:Int){
        viewModel.deleteToDoItem(id)
    }
}
