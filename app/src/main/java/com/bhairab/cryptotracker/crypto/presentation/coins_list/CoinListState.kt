package com.bhairab.cryptotracker.crypto.presentation.coins_list

import androidx.compose.runtime.Immutable
import com.bhairab.cryptotracker.crypto.presentation.models.CoinUi

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
// REVIEW(1) This class variables are not changed, and when changed, the whole instance will be replaced
@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    //The annotation because the read-only list is not always stable, so compose is not always capable to know if this is immutable or not (to avoid un-necessary recompose)
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
