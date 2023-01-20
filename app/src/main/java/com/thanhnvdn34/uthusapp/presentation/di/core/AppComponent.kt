package com.thanhnvdn34.uthusapp.presentation.di.core

import com.thanhnvdn34.uthusapp.presentation.di.beer.BeerSubComponent
import com.thanhnvdn34.uthusapp.presentation.di.favorite.FavoriteSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class
])
interface AppComponent {

    fun beerSubComponent(): BeerSubComponent.Factory

    fun favoriteSubComponent(): FavoriteSubComponent.Factory
}