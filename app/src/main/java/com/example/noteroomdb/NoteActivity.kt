package com.example.noteroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noteroomdb.db.NoteRepository
import com.example.noteroomdb.db.entities.NoteEntity

class NoteActivity : AppCompatActivity() {

    private lateinit var noteRepository: NoteRepository
    private lateinit var addNote: Button
    private lateinit var editTitle: EditText
    private lateinit var editDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        init()
    }

    private fun init(){
        editTitle = findViewById(R.id.editTitle)
        editDescription = findViewById(R.id.editDescription)
        addNote = findViewById(R.id.button)
        noteRepository = NoteRepository(this)
        addNote.setOnClickListener {
            noteData()
        }
    }

    private fun noteData(){
        if (editTitle.text.isNullOrBlank() || editDescription.text.isNullOrBlank()){
            Toast.makeText(this, "Title or Description is empty", Toast.LENGTH_SHORT).show()
        } else {
            val noteEntity = NoteEntity(title = editTitle.text.toString(), description = editDescription.text.toString())
            noteRepository.insertData(noteEntity)
            finish()
        }
    }
}