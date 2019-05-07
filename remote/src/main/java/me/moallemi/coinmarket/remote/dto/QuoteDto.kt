package me.moallemi.coinmarket.remote.dto


import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @SerializedName("USD") val uSD: UsdDto?
)