package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
     fun providesCoinInfoDao(application: Application): CoinInfoDao {
        return AppDatabase.getInstance(application).coinInfoDao()
    }
}