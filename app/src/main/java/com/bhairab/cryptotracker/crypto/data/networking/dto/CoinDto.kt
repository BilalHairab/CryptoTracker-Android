package com.bhairab.cryptotracker.crypto.data.networking.dto

import kotlinx.serialization.Serializable

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
//REVIEW(9): we can add this annotation to Coin in domain, but this is violation. for two reasons:
//(1): to avoid coupling domain with implementation details
//(2): if we want to use in Coin non-primitive data like DataZone

@Serializable
data class CoinDto(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double
)
