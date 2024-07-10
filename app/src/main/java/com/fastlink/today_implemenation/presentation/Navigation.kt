package com.fastlink.today_implemenation.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavController,viewModel: NoteViewModel){
    NavHost(navController as NavHostController, startDestination = Screens.NoteScreen.sRoute){
        composable(route = Screens.NoteScreen.sRoute){
            HomeScreen(viewModel = viewModel,navController = navController)
        }
        composable(route = Screens.AddNoteScreen.sRoute){
            AddNoteScreen(viewModel = viewModel,navController)
        }
    }
}