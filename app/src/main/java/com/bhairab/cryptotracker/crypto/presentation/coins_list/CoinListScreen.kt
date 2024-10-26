package com.bhairab.cryptotracker.crypto.presentation.coins_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bhairab.cryptotracker.crypto.presentation.coins_list.components.CoinListItem
import com.bhairab.cryptotracker.crypto.presentation.coins_list.components.previewCoin
import com.bhairab.cryptotracker.crypto.presentation.models.CoinListAction
import com.bhairab.cryptotracker.crypto.presentation.models.toCoinUi
import com.bhairab.cryptotracker.ui.theme.CryptoTrackerTheme

/**
 * Created by Bilal Hairab on 25/10/2024.
 */

@Composable
fun CoinListScreen(
    state: CoinListState,
    onAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp))
        {
            items(state.coins) { coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = { onAction(CoinListAction.OnCoinClickAction(coinUi)) },
                    modifier = modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    CryptoTrackerTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map {
                    previewCoin.toCoinUi().copy(id = it.toString())
                }
            ),
            onAction = {

            },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
