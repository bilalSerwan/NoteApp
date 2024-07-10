package com.fastlink.today_implemenation

import android.app.Application
import androidx.room.Room
import com.fastlink.today_implemenation.data.NoteDatabase

class NoteApplication : Application(){
    companion object{
        lateinit var notedatabse:NoteDatabase
    }
    override fun onCreate() {
        super.onCreate()
        notedatabse = Room.databaseBuilder(
           context=this,
           klass= NoteDatabase::class.java,
           name=NoteDatabase.DATABASE_NAME
        ).build()
    }
}