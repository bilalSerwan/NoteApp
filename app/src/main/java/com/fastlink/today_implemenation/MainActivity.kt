package com.fastlink.today_implemenation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.fastlink.today_implemenation.presentation.HomeScreen
import com.fastlink.today_implemenation.presentation.Navigation
import com.fastlink.today_implemenation.presentation.NoteViewModel
import com.fastlink.today_implemenation.ui.theme.TodayimplemenationTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel :NoteViewModel= viewModel()
            val navController = rememberNavController()
            TodayimplemenationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                 Navigation(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}