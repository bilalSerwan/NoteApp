package com.fastlink.today_implemenation.presentation

sealed class Screens(val sName:String , val sRoute:String){
    data object NoteScreen:Screens(sName = "Note App",sRoute = "note_screen")
    data object AddNoteScreen:Screens(sName = "add Note",sRoute = "add_note_screen")
}