package com.bhairab.cryptotracker.crypto.presentation.coins_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhairab.cryptotracker.core.domain.util.onError
import com.bhairab.cryptotracker.core.domain.util.onSuccess
import com.bhairab.cryptotracker.crypto.domain.CoinDataSource
import com.bhairab.cryptotracker.crypto.presentation.models.CoinListAction
import com.bhairab.cryptotracker.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
//REVIEW(10): depend on abstractions (enhance testing)
class CoinListViewModel(
    private val coinDataSource: CoinDataSource
) : ViewModel() {
    //REVIEW(11): protect UI from taking in-correct (buggy update) of the state + prevent UI from editing the state
    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()
        //REVIEW(14): when subscribed
        .onStart {
            loadCoins()
        }
        //REVIEW(15): stop after all subscribers gone + 5 seconds
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), CoinListState())

    //REVIEW(13): works, but not recommended, because it acts like a side effect + hardens testing
//    init {
//        loadCoins()
//    }

    fun onAction(action: CoinListAction) {
        when(action) {
            is CoinListAction.OnCoinClickAction -> {

            }
            is CoinListAction.OnRefreshAction -> {
                loadCoins()
            }
        }
    }

    private fun loadCoins() {
        viewModelScope.launch {
            //REVIEW(12): update state thread safely
            _state.update {
                it.copy(isLoading = true)
            }
            coinDataSource.getCoins().onSuccess { coins ->
                _state.update { it.copy(isLoading = false, coins = coins.map { coin -> coin.toCoinUi() }) }
            }.onError { error ->
                _state.update { it.copy(isLoading = false) }

            }
        }
    }
}