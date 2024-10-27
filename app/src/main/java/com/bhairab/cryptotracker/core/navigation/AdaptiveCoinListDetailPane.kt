package com.bhairab.cryptotracker.core.navigation

import android.widget.Toast
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bhairab.cryptotracker.core.presentation.util.ObserveAsEvents
import com.bhairab.cryptotracker.core.presentation.util.toString
import com.bhairab.cryptotracker.crypto.presentation.coin_detail.CoinDetailScreen
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListEvent
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListScreen
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListViewModel
import com.bhairab.cryptotracker.crypto.presentation.models.CoinListAction
import org.koin.androidx.compose.koinViewModel

/**
 * Created by Bilal Hairab on 27/10/2024.
 */

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AdaptiveCoinListDetailPane(
    modifier: Modifier = Modifier,
    viewModel: CoinListViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    ObserveAsEvents(events = viewModel.events) { event ->
        when (event) {
            is CoinListEvent.Error -> {
                Toast.makeText(context, event.error.toString(context), Toast.LENGTH_LONG).show()
            }
        }
    }
    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()
    NavigableListDetailPaneScaffold(navigator = navigator, listPane = {
        AnimatedPane {
            CoinListScreen(
                state = state,
                onAction = { action ->
                    viewModel.onAction(action)
                    when (action) {
                        is CoinListAction.OnCoinClickAction -> {
                            navigator.navigateTo(
                                pane = ListDetailPaneScaffoldRole.Detail
                            )
                        }

                        else -> {}
                    }
                }
            )
        }
    }, detailPane = {
        AnimatedPane {
            CoinDetailScreen(state = state)
        }
    },
        modifier = modifier
    )
}