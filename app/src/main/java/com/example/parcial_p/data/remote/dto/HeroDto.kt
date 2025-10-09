package com.example.parcial_p.data.remote.dto

data class HeroDto(
    val id: Int,
    val name: String,
    val slug: String?,
    val powerstats: PowerstatsDto?,
    val appearance: AppearanceDto?,
    val biography: BiographyDto?,
    val work: WorkDto?,
    val connections: ConnectionsDto?,
    val images: ImagesDto?
)

data class PowerstatsDto(
    val intelligence: Int?,
    val strength: Int?,
    val speed: Int?,
    val durability: Int?,
    val power: Int?,
    val combat: Int?
)

data class AppearanceDto(
    val gender: String?,
    val race: String?,
    val height: List<String>?,
    val weight: List<String>?,
    val eyeColor: String?,
    val hairColor: String?
)

data class BiographyDto(
    val fullName: String?,
    val publisher: String?,
    val firstAppearance: String?,
    val aliases: List<String>? = null
)

data class WorkDto(
    val occupation: String?,
    val base: String?
)

data class ConnectionsDto(
    val groupAffiliation: String?,
    val relatives: String?
)

data class ImagesDto(
    val sm: String?,
    val md: String?,
    val lg: String?
)