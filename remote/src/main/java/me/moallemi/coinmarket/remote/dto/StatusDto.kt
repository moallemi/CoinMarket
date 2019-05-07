package me.moallemi.coinmarket.remote.dto


import com.google.gson.annotations.SerializedName

data class StatusDto(
    @SerializedName("credit_count") val creditCount: Int?,
    @SerializedName("elapsed") val elapsed: Int?,
    @SerializedName("error_code") val errorCode: Int?,
    @SerializedName("error_message") val errorMessage: Any?,
    @SerializedName("timestamp") val timestamp: String?
)