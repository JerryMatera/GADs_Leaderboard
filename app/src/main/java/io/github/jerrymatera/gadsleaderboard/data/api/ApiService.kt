package io.github.jerrymatera.gadsleaderboard.data.api

import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService  {
    @GET("/api/hours")
    suspend fun getLearningLeaders(): Response<List<LearningLeader>>

    @GET("/api/skilliq")
    suspend fun  getSkillIQLeaders(): Response<List<SkillIQLeader>>

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    fun submitGoogle(
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") linkToProject: String
    ): Call<Void>
}