package com.bhairab.cryptotracker.crypto.data.mappers

import com.bhairab.cryptotracker.crypto.data.networking.dto.CoinDto
import com.bhairab.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import com.bhairab.cryptotracker.crypto.domain.Coin
import com.bhairab.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

/**
 * Created by Bilal Hairab on 25/10/2024.
 */

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant.ofEpochMilli(time).atZone(ZoneId.of("UTC"))
    )
}