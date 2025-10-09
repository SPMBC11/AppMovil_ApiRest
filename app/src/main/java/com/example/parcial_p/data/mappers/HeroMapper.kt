package com.example.parcial_p.data.mappers

import com.example.parcial_p.data.model.HeroDetailInfo
import com.example.parcial_p.data.model.HeroInfo
import com.example.parcial_p.data.remote.dto.HeroDto

object HeroMapper {
    fun toHeroInfo(dto: HeroDto): HeroInfo {
        return HeroInfo(
            id = dto.id,
            name = dto.name,
            fullName = dto.biography?.fullName ?: "",
            publisher = dto.biography?.publisher ?: "Unknown",
            imageUrl = dto.images?.sm ?: dto.images?.md ?: dto.images?.lg.orEmpty()
        )
    }

    fun toHeroDetail(dto: HeroDto): HeroDetailInfo {
        val powerMap = mapOf(
            "intelligence" to dto.powerstats?.intelligence,
            "strength" to dto.powerstats?.strength,
            "speed" to dto.powerstats?.speed,
            "durability" to dto.powerstats?.durability,
            "power" to dto.powerstats?.power,
            "combat" to dto.powerstats?.combat
        )
        return HeroDetailInfo(
            id = dto.id,
            name = dto.name,
            fullName = dto.biography?.fullName ?: "",
            publisher = dto.biography?.publisher ?: "Unknown",
            biography = dto.biography?.aliases?.joinToString(", ")
                .takeIf { !dto.biography?.aliases.isNullOrEmpty() },
            firstAppearance = dto.biography?.firstAppearance,
            powerstats = powerMap,
            imageUrlLarge = dto.images?.lg ?: dto.images?.md ?: dto.images?.sm.orEmpty()
        )
    }
}