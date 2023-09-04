package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.dao.TasksList
import com.example.todolist.model.Tarefas

class CriacaoTarefaActivity : AppCompatActivity() {

    lateinit var tarefa : EditText;
    lateinit var descricao: EditText;
    lateinit var btnAdd : Button
    lateinit var tarefaEscrita : String;
    lateinit var descricaoEscrita : String
    lateinit var listaDeTarefas : MutableList<Tarefas>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criacao_tarefa)

        catchIds()
        adicionaTarefa()

    }

    fun adicionaTarefa() {

        btnAdd.setOnClickListener() {
            tarefa = findViewById(R.id.ED_NomeTarefa)
            descricao = findViewById(R.id.ED_DescricaoTarefa)

            tarefaEscrita = tarefa.text.toString()
            descricaoEscrita = descricao.text.toString()

            val item = Tarefas(
                titulo = tarefaEscrita,
                descricao = descricaoEscrita
            )

            TasksList().add(item)
        }
    }

    fun catchIds() {
        btnAdd = findViewById(R.id.btn_adicionar)
    }




}