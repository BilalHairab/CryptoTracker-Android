package com.bhairab.cryptotracker.crypto.data.networking

import com.bhairab.cryptotracker.core.data.networking.constructUrl
import com.bhairab.cryptotracker.core.data.networking.safeCall
import com.bhairab.cryptotracker.core.domain.util.NetworkError
import com.bhairab.cryptotracker.core.domain.util.Result
import com.bhairab.cryptotracker.core.domain.util.map
import com.bhairab.cryptotracker.crypto.data.mappers.toCoin
import com.bhairab.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.bhairab.cryptotracker.crypto.domain.Coin
import com.bhairab.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
class RemoteCoinDataSource(private val httpClient: HttpClient) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(urlString = constructUrl("/assets"))
        }.map { response ->
            response.data.map { element -> element.toCoin() }
        }
    }
}