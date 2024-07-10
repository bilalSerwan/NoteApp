package com.fastlink.today_implemenation.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao{
    @Query("SELECT * FROM NoteModel")
    fun getAllNotes() : LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: NoteModel)


    @Query("DELETE FROM NoteModel WHERE id = :id")
    fun delete(id:Int)
}