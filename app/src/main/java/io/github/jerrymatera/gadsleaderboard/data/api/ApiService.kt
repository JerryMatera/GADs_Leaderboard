package io.github.jerrymatera.gadsleaderboard.data.api

import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader
import retrofit2.Response
import retrofit2.http.GET

interface ApiService  {
    @GET("/api/hours")
    suspend fun getLearningLeaders(): Response<List<LearningLeader>>

    @GET("/api/skilliq")
    suspend fun  getSkillIQLeaders(): Response<List<SkillIQLeader>>
}