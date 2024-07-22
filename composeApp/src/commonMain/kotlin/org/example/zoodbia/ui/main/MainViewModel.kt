package org.example.zoodbia.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.zoodbia.domain.usecases.GetMainProductsUseCase

class MainViewModel(
    private val getMainProductsUseCase: GetMainProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun makeRequest() {
        viewModelScope.launch {
            runCatching {
                _uiState.update { it.copy(products = getMainProductsUseCase.execute()) }
            }
        }
    }

    data class UiState(
        val products: List<String> = listOf()
    )
}