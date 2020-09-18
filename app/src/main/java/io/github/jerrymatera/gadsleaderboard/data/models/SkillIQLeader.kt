package io.github.jerrymatera.gadsleaderboard.data.models

import com.google.gson.annotations.SerializedName

data class SkillIQLeader(
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("badgeUrl")
    val badgeUrl: String
)