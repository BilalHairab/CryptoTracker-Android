package com.bhairab.cryptotracker.crypto.data.networking.dto

import kotlinx.serialization.Serializable

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
@Serializable
data class CoinsResponseDto(
    val data: List<CoinDto>
)
