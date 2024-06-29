package org.example.zoodbia.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.zoodbia.domain.GetMainProductsUseCase

class MainViewModel(
    private val getMainProductsUseCase: GetMainProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(products = getMainProductsUseCase.execute()) }
    }

    data class UiState(
        val products: List<String> = listOf()
    )
}