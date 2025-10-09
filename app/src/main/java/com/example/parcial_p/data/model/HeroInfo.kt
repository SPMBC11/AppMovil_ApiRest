package com.example.parcial_p.data.model

data class HeroInfo(
    val id: Int,
    val name: String,
    val fullName: String,
    val publisher: String,
    val imageUrl: String
)

data class HeroDetailInfo(
    val id: Int,
    val name: String,
    val fullName: String,
    val publisher: String,
    val biography: String?,
    val firstAppearance: String?,
    val powerstats: Map<String, Int?>,
    val imageUrlLarge: String
)