package com.bhairab.cryptotracker.crypto.presentation.models

/**
 * Created by Bilal Hairab on 26/10/2024.
 */
sealed interface CoinListAction {
    data class OnCoinClickAction(val coinUi: CoinUi) : CoinListAction
    data object OnRefreshAction : CoinListAction
}