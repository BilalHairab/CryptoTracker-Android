package com.bhairab.cryptotracker.crypto.data.mappers

import com.bhairab.cryptotracker.crypto.data.networking.dto.CoinDto
import com.bhairab.cryptotracker.crypto.domain.Coin

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