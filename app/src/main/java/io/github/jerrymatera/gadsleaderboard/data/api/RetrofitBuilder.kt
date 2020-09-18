package io.github.jerrymatera.gadsleaderboard.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

        val BASE_URL = "https://gadsapi.herokuapp.com/"
    
        val SUBMIT_BASE_URL = "https://docs.google.com/forms/d/e/"

        private fun getRetrofit() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

}