package com.bhairab.cryptotracker.crypto.presentation.coins_list

import com.bhairab.cryptotracker.core.domain.util.NetworkError

/**
 * Created by Bilal Hairab on 26/10/2024.
 */
sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}