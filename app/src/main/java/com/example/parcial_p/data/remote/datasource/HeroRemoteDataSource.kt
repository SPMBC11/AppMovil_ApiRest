package com.example.parcial_p.data.remote.datasource

import com.example.parcial_p.data.remote.dto.HeroDto

interface HeroRemoteDataSource {
    suspend fun fetchAllHeroes(): List<HeroDto>
    suspend fun fetchHeroById(id: Int): HeroDto
}