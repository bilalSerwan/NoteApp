package com.fastlink.today_implemenation.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [NoteModel::class],
    version = 1,
    exportSchema = false)
abstract class NoteDatabase:RoomDatabase(){
    abstract fun getNoteDao():NoteDao
    companion object{
        const val DATABASE_NAME = "note_db"
    }

}