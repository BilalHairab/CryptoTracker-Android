package com.bhairab.cryptotracker.di

import com.bhairab.cryptotracker.core.data.networking.HttpClientFactory
import com.bhairab.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import com.bhairab.cryptotracker.crypto.domain.CoinDataSource
import com.bhairab.cryptotracker.crypto.presentation.coins_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by Bilal Hairab on 26/10/2024.
 */
val appModule = module {
    //Singleton
    single {
        HttpClientFactory.create(CIO.create())
    }
    //In case of abstraction: when CoinDataSource is requested, give: RemoteCoinDataSource
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()
    //OR:
//    single {
//        RemoteCoinDataSource(get())
//    }

    viewModelOf(::CoinListViewModel)
}