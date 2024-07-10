package com.fastlink.today_implemenation.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fastlink.today_implemenation.NoteApplication
import com.fastlink.today_implemenation.data.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class NoteViewModel : ViewModel() {


    private val noteDao = NoteApplication.notedatabse.getNoteDao()
    val noteList : LiveData<List<NoteModel>> =noteDao.getAllNotes()

   fun addNote(title:String){
       viewModelScope.launch(Dispatchers.IO) {
       noteDao.insert(NoteModel(name=title))
       }
   }

    fun deleteNote(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
        noteDao.delete(id)
        }
    }

    fun validateTitle(title:String):Boolean{
        return title.isEmpty()
    }
}