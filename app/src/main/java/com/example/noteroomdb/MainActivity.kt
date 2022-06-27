package com.example.noteroomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteroomdb.db.NoteRepository
import com.example.noteroomdb.db.entities.NoteEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNoteBtn: FloatingActionButton
    private lateinit var noteRepository: NoteRepository

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
        noteRepository = NoteRepository(this)

        addNoteBtn.setOnClickListener {
            val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }
        noteRepository.getAllNotes().observe(this) { notes ->
            noteAdapter.submitList(notes)
            noteAdapter.notifyDataSetChanged()
        }
    }

    override fun onStart() {
        super.onStart()
        noteRepository.getAllNotes().observe(this) { notes ->
            noteAdapter.submitList(notes)
            noteAdapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        noteRepository.getAllNotes().observe(this) { notes ->
            noteAdapter.submitList(notes)
            noteAdapter.notifyDataSetChanged()
        }
    }
}