package com.example.noteroomdb.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.noteroomdb.db.entities.NoteEntity
import kotlinx.coroutines.*

class NoteRepository(context: Context) {

    private val db = NoteDatabase.invoke(context)

    fun getAllNotes() : LiveData<List<NoteEntity>> = db.noteDao().selectAllNotes()

    @OptIn(DelicateCoroutinesApi::class)
    fun insertData(noteEntity: NoteEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.noteDao().insertNote(noteEntity)
            }
        }
    }
}