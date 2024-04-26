package com.example.cryptoapp

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.example.cryptoapp.di.DaggerApplicationComponent

class CoinApplication: Application(), Configuration.Provider {
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(
                RefreshDataWorkerFactory(
                    AppDatabase.getInstance(this).coinInfoDao(),
                    ApiFactory.apiService,
                    CoinMapper()
                )
            ).build()
    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}