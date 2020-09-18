package io.github.jerrymatera.gadsleaderboard.data.models

import com.google.gson.annotations.SerializedName

data class LearningLeader(
    @SerializedName("name")
    val name: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("badgeUrl")
    val badgeUrl: String
)