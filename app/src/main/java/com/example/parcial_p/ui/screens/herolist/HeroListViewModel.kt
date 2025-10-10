package com.example.parcial_p.ui.screens.herolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_p.data.model.HeroInfo
import com.example.parcial_p.data.repository.HeroRepository
import com.example.parcial_p.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.parcial_p.ui.screens.herolist.HeroListUIState

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroListUIState(isLoading = true))
    val uiState: StateFlow<HeroListUIState> = _uiState.asStateFlow()

    init {
        loadAllHeroes()
    }

    fun loadAllHeroes() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            when (val result = repository.getAllHeroes()) {
                is Result.Success -> _uiState.update { it.copy(isLoading = false, heroes = result.data) }
                is Result.Error -> _uiState.update { it.copy(isLoading = false, errorMessage = result.throwable.message ?: "Error de red") }
            }
        }
    }
}