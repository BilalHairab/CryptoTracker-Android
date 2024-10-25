package com.bhairab.cryptotracker.crypto.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.bhairab.cryptotracker.crypto.domain.Coin
import com.bhairab.cryptotracker.util.getDrawableIdForCoin
import java.util.Locale

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int,
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi(): CoinUi {
    return  CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol),
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return  DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}