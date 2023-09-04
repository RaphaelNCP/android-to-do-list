package com.example.todolist.dao

import com.example.todolist.model.Tarefas

class TasksList {

    fun add(tarefa: Tarefas){
        Companion.listaTarefas.add(tarefa)
    }

    fun show() : List<Tarefas>{
        return Companion.listaTarefas.toList()
    }

    companion object {
        private val listaTarefas = mutableListOf<Tarefas>()
    }
}