package com.example.parcial_p.data.repository

import com.example.parcial_p.data.mappers.HeroMapper
import com.example.parcial_p.data.model.HeroDetailInfo
import com.example.parcial_p.data.model.HeroInfo
import com.example.parcial_p.data.remote.datasource.HeroRemoteDataSource
import com.example.parcial_p.util.Result
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val remote: HeroRemoteDataSource
) : HeroRepository {

    override suspend fun getAllHeroes(): Result<List<HeroInfo>> {
        return try {
            val dtos = remote.fetchAllHeroes()
            val list = dtos.map { HeroMapper.toHeroInfo(it) }
            Result.Success(list)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getHeroById(id: Int): Result<HeroDetailInfo> {
        return try {
            val dto = remote.fetchHeroById(id)
            Result.Success(HeroMapper.toHeroDetail(dto))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}