package io.github.jerrymatera.gadsleaderboard.data.network

import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GadsApiService {
    @GET("/api/hours")
    suspend fun getLearningLeaders(): List<LearningLeader>

    @GET("/api/skilliq")
    suspend fun getSkillIQLeaders(): List<SkillIQLeader>

    companion object {
        private const val BASE_URL = "https://gadsapi.herokuapp.com/"

        fun create(): GadsApiService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GadsApiService::class.java)
        }
    }
}
