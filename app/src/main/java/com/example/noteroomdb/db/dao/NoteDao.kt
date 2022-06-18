package com.example.noteroomdb.db.dao

import androidx.room.*
import com.example.noteroomdb.db.entities.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun selectAllNotes(): List<NoteEntity>

    @Insert
    fun insertNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)
}