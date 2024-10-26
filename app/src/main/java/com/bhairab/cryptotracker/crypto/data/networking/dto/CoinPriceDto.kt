package com.bhairab.cryptotracker.crypto.data.networking.dto

import kotlinx.serialization.Serializable

/**
 * Created by Bilal Hairab on 26/10/2024.
 */
@Serializable
data class CoinPriceDto(val priceUsd: Double, val time: Long)
