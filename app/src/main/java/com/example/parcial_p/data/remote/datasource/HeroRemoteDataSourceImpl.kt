package com.example.parcial_p.data.remote.datasource

import com.example.parcial_p.data.remote.api.HeroApi
import com.example.parcial_p.data.remote.dto.HeroDto
import javax.inject.Inject

class HeroRemoteDataSourceImpl @Inject constructor(
    private val api: HeroApi
) : HeroRemoteDataSource {

    override suspend fun fetchAllHeroes(): List<HeroDto> = api.getAllHeroes()

    override suspend fun fetchHeroById(id: Int): HeroDto = api.getHeroById(id)
}