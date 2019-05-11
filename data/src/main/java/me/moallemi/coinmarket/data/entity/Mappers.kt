package me.moallemi.coinmarket.data.entity

import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.domain.model.Quote
import me.moallemi.coinmarket.domain.model.Usd


fun CurrencyInfoEntity.toCurrencyInfo() = CurrencyInfo(
    name = name,
    symbol = symbol,
    slug = slug,
    quote = quote.toQuote()
)

fun QuoteEntity.toQuote() = Quote(
    uSD = uSD?.toUsd()
)

fun UsdEntity.toUsd() = Usd(
    lastUpdated = lastUpdated,
    marketCap = marketCap,
    percentChange1h = percentChange1h,
    percentChange24h = percentChange24h,
    percentChange7d = percentChange7d,
    price = price,
    volume24h = volume24h
)