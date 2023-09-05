package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapters.AdapterTask
import com.example.todolist.dao.TasksList
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAdd : MaterialButton
    private lateinit var rvListaDeTarefas : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catchIds()
        addTaskScreen()
        setupList()
        configAdapter()
    }

    override fun onResume() {
        super.onResume()
        setupList()
        configAdapter()
    }

    private fun catchIds() {
        buttonAdd = findViewById(R.id.FAT_addTarefa)
        rvListaDeTarefas = findViewById(R.id.RV_listaTarefas)

    }

    private fun setupList() {
        rvListaDeTarefas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvListaDeTarefas.setHasFixedSize(true)
    }

    private fun addTaskScreen() {
        buttonAdd.setOnClickListener(){
            startActivity(Intent(this, CriacaoTarefaActivity::class.java))
        }
    }

    private fun configAdapter() {
        val adapterLista = AdapterTask(this, TasksList().show().toMutableList())
        rvListaDeTarefas.adapter = adapterLista
    }
}