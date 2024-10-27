package com.bhairab.cryptotracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bhairab.cryptotracker.core.navigation.AdaptiveCoinListDetailPane
import com.bhairab.cryptotracker.core.presentation.util.ObserveAsEvents
import com.bhairab.cryptotracker.core.presentation.util.toString
import com.bhairab.cryptotracker.crypto.presentation.coin_detail.CoinDetailScreen
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListEvent
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListScreen
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListViewModel
import com.bhairab.cryptotracker.ui.theme.CryptoTrackerTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}