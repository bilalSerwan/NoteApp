package com.fastlink.today_implemenation.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fastlink.today_implemenation.AppBar
import com.fastlink.today_implemenation.R

@Composable
fun AddNoteScreen(viewModel: NoteViewModel,navController: NavController) {
    var titleController: String by remember {
        mutableStateOf("")
    }
    val isError= remember {
        mutableStateOf(false)
    }
Scaffold(
    topBar = {
        AppBar(
            title = "Add Note",
            icon = Icons.Default.ArrowBack,
            iconClicked = {
                navController.navigateUp()
            }
        )
    }
) {
   Column(modifier = Modifier
       .padding(it)
       .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {
       Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 5.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween) {
           Text(text = "Title")
           if(isError.value){
                Text(text = "Title is required", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
           }
       }
           OutlinedTextField(
               modifier = Modifier
                   .padding(4.dp)
                   .size(328.dp, height = 78.dp),
               value = titleController,
               onValueChange = { v ->
                   isError.value = false
                   titleController = v },
               shape = RoundedCornerShape(5.dp),
               singleLine = true,
               isError = isError.value,
               prefix = {
                  Icon(painter = painterResource(id = R.drawable.ic_title),
                      contentDescription = null, tint = if(isError.value)MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface)
               },
               keyboardOptions = KeyboardOptions(
                   capitalization = KeyboardCapitalization.Words,
                   autoCorrect = true,
                   keyboardType = KeyboardType.Text,
               ),
           )
       Button(onClick = {
                        isError.value = viewModel.validateTitle(titleController)

           if(!isError.value){
                viewModel.addNote(titleController)
               titleController=""
                navController.navigateUp()
           }
       }, modifier = Modifier.padding(16.dp),
           colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
           Text(text ="Add Note", modifier = Modifier.padding(8.dp), color = MaterialTheme.colorScheme.onSurface)
       }

   }
}
}