package com.nneka.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nneka.retrofit.databinding.TodoItemBinding

class TodoAdapter(var lists: List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(list: Todo){
            binding.textView.text = list.title

            if (list.completed){
                binding.imageView.visibility = View.VISIBLE
            }else{
                binding.imageView.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
       val singleTodo = lists.get(position)
        holder.bind(singleTodo)
    }

    override fun getItemCount(): Int {
        return lists.size
    }


}