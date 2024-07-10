package com.fastlink.today_implemenation.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fastlink.today_implemenation.AppBar
import com.fastlink.today_implemenation.R
import com.fastlink.today_implemenation.data.NoteModel


@Composable
fun HomeScreen(viewModel: NoteViewModel,navController: NavController){
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
          AppBar(title = "Note App", icon = null)
        },
        floatingActionButton = {FAB(onClicked = {
            navController.navigate(Screens.AddNoteScreen.sRoute)},)}
        ){
        Column(modifier = Modifier
            .padding(it).fillMaxSize())
        {
            val notes by  viewModel.noteList.observeAsState()

            //if we don't have any note
            if(notes?.size==0){
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "No Notes")
                }
            }else{
        notes?.let {
        LazyColumn{
            items(notes!!){ note->
                NoteItem(note = note, deleteIconClicked = {
                    viewModel.deleteNote(note.id) })
            }//items
        } //lazyColumn
        }//let
            }//else
        }//surface
    }//scaffold-body
}//fun

@Composable
fun NoteItem(note: NoteModel,deleteIconClicked:()->Unit){
    Surface(modifier = Modifier.padding(8.dp),  shape = RoundedCornerShape(10.dp),shadowElevation = 5.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = note.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
            IconButton(onClick = deleteIconClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    tint = MaterialTheme.colorScheme.error,
                    contentDescription = "Remove",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Composable
fun FAB(onClicked:()->Unit){
    FloatingActionButton(onClick = onClicked,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .size(65.dp),
        shape = CircleShape){
        Icon(imageVector = Icons.Default.Add,
            contentDescription = "add",
            tint = MaterialTheme.colorScheme.onSurface)
    }
}