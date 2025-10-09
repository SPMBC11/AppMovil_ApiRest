package com.example.parcial_p.ui.screens.herodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_p.data.model.HeroDetailInfo
import com.example.parcial_p.data.repository.HeroRepository
import com.example.parcial_p.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HeroDetailUIState(
    val isLoading: Boolean = false,
    val hero: HeroDetailInfo? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val repository: HeroRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroDetailUIState(isLoading = true))
    val uiState: StateFlow<HeroDetailUIState> = _uiState.asStateFlow()

    init {
        val id = savedStateHandle.get<Int>("heroId") ?: 0
        if (id != 0) loadHero(id) else _uiState.update { it.copy(isLoading = false, errorMessage = "ID inválido") }
    }

    fun loadHero(id: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            when (val result = repository.getHeroById(id)) {
                is Result.Success -> _uiState.update { it.copy(isLoading = false, hero = result.data) }
                is Result.Error -> _uiState.update { it.copy(isLoading = false, errorMessage = result.throwable.message ?: "Error de red") }
            }
        }
    }
}