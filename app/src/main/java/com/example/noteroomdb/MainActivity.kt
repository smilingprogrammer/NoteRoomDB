package com.example.noteroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNoteBtn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        noteAdapter = NoteAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerview)
        addNoteBtn = findViewById(R.id.float_button)
        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}