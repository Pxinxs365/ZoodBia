package org.example.zoodbia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import org.example.zoodbia.di.koinViewModel
import org.example.zoodbia.ui.main.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                // TODO: For future usage of ViewModel
                val viewModel = koinViewModel<MainViewModel>()
                MainActivityContent(viewModel)
            }
        }
    }
}
