package com.example.todolist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.Tarefas

class AdapterTask(private val context: Context, private val tasks: MutableList<Tarefas>) : RecyclerView.Adapter<AdapterTask.ViewHolderList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        val tasklist = LayoutInflater.from(context).inflate(R.layout.tarefa_item, parent, false)
        return ViewHolderList(tasklist)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        holder.titulo.text = tasks[position].titulo
        holder.descricao.text = tasks[position].descricao
    }

    override fun getItemCount() = tasks.size

    inner class ViewHolderList(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val titulo : TextView = itemView.findViewById(R.id.TV_titulo)
        val descricao : TextView = itemView.findViewById(R.id.TV_descricao)
    }

}