package io.github.jerrymatera.gadsleaderboard.network

import io.github.jerrymatera.gadsleaderboard.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.models.SkillIQLeader
import retrofit2.Response
import retrofit2.http.GET

interface GadsApiService  {
    @GET("/api/hours")
    suspend fun getLearningLeaders(): Response<List<LearningLeader>>

    @GET("/api/skilliq")
    suspend fun  getSkillIQLeaders(): Response<List<SkillIQLeader>>
}