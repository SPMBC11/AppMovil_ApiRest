package com.example.parcial_p.data.repository

import com.example.parcial_p.data.model.HeroDetailInfo
import com.example.parcial_p.data.model.HeroInfo
import com.example.parcial_p.util.Result

interface HeroRepository {
    suspend fun getAllHeroes(): Result<List<HeroInfo>>
    suspend fun getHeroById(id: Int): Result<HeroDetailInfo>
}