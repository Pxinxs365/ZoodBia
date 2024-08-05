package org.example.zoodbia

import androidx.compose.runtime.*
import org.example.zoodbia.navigation.navcontroller.AppNavController
import org.example.zoodbia.ui.main.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainActivityContent(viewModel: MainViewModel) {
    val uiState = viewModel.uiState.collectAsState().value
    MainActivityScreen(uiState)
}

@Composable
private fun MainActivityScreen(uiState: MainViewModel.UiState) {
    // TODO: Use uiState to display data on UI
    AppNavController()
}

@Preview
@Composable
private fun MainActivityScreenPreview() {
    MainActivityScreen(
        uiState = MainViewModel.UiState(
            products = listOf()
        )
    )
}