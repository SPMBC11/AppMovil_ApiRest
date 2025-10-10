package com.example.parcial_p.ui.screens.herodetail

import com.example.parcial_p.data.model.HeroDetailInfo

data class HeroDetailUIState(
    val isLoading: Boolean = false,
    val hero: HeroDetailInfo? = null,
    val errorMessage: String? = null
)
