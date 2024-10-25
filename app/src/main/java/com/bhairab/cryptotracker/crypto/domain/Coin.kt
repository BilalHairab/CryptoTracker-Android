package com.bhairab.cryptotracker.crypto.domain

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
data class Coin(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double
)
