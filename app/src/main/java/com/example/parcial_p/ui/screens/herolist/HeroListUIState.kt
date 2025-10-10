package com.example.parcial_p.ui.screens.herolist

import com.example.parcial_p.data.model.HeroInfo

data class HeroListUIState(
    val isLoading: Boolean = false,
    val heroes: List<HeroInfo> = emptyList(),
    val errorMessage: String? = null
)