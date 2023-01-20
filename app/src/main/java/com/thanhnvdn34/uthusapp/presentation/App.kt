package com.thanhnvdn34.uthusapp.presentation

import android.app.Application
import com.thanhnvdn34.uthusapp.BuildConfig
import com.thanhnvdn34.uthusapp.presentation.di.Injector
import com.thanhnvdn34.uthusapp.presentation.di.core.*
import com.thanhnvdn34.uthusapp.presentation.di.beer.BeerSubComponent
import com.thanhnvdn34.uthusapp.presentation.di.favorite.FavoriteSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createBeerSubComponent(): BeerSubComponent {
        return appComponent.beerSubComponent().create()
    }

    override fun createFavoriteSubComponent(): FavoriteSubComponent {
        return appComponent.favoriteSubComponent().create()
    }
}