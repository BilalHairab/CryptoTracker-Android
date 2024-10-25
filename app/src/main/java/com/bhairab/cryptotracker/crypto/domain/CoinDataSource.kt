package com.bhairab.cryptotracker.crypto.domain

import com.bhairab.cryptotracker.core.domain.util.NetworkError
import com.bhairab.cryptotracker.core.domain.util.Result

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
//REVIEW(7): what should it fetch? (because domain layer), but how fetch => data layer
//REVIEW(8): data + presentation => can access domain (not vice versa)
interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}