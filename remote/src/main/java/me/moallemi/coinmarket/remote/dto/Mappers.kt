package me.moallemi.coinmarket.remote.dto

import me.moallemi.coinmarket.data.entity.CurrencyInfoEntity
import me.moallemi.coinmarket.data.entity.QuoteEntity
import me.moallemi.coinmarket.data.entity.UsdEntity

fun ListingsDto.toCurrencyInfoEntityList() = items.map { currencyInfoDto ->
    currencyInfoDto.toCurrencyInfoEntity()
}

fun CurrencyInfoDto.toCurrencyInfoEntity() = CurrencyInfoEntity(
    name = name,
    symbol = symbol,
    slug = slug,
    quote = quote.toQuoteEntity()
)

fun QuoteDto.toQuoteEntity() = QuoteEntity(
    uSD = uSD?.toUsdEntity()
)

fun UsdDto.toUsdEntity() = UsdEntity(
    lastUpdated = lastUpdated,
    marketCap = marketCap,
    percentChange1h = percentChange1h,
    percentChange24h = percentChange24h,
    percentChange7d = percentChange7d,
    price = price,
    volume24h = volume24h
)