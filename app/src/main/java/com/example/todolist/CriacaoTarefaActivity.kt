package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.dao.TasksList
import com.example.todolist.model.Tarefas
import cn.pedant.SweetAlert.SweetAlertDialog;

class CriacaoTarefaActivity : AppCompatActivity() {

    private lateinit var tarefa : EditText;
    private lateinit var descricao: EditText;
    private lateinit var btnAdd : Button
    private lateinit var tarefaEscrita : String;
    private lateinit var descricaoEscrita : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criacao_tarefa)

        catchIds()
        adicionaTarefa()

    }

    private fun adicionaTarefa() {

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

            SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Tarefa Adicionada")
                .setConfirmClickListener(SweetAlertDialog.OnSweetClickListener(){
                    finish()
                }).show()

        }
    }
    private fun catchIds() {
        btnAdd = findViewById(R.id.btn_adicionar)
    }
}