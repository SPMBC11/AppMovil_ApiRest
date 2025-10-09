package com.example.parcial_p.data.remote.api

import com.example.parcial_p.data.remote.dto.HeroDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {
    @GET("all.json")
    suspend fun getAllHeroes(): List<HeroDto>

    @GET("id/{id}.json")
    suspend fun getHeroById(@Path("id") heroId: Int): HeroDto
}