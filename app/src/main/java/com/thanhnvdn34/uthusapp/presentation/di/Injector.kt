package com.thanhnvdn34.uthusapp.presentation.di

import com.thanhnvdn34.uthusapp.presentation.di.beer.BeerSubComponent
import com.thanhnvdn34.uthusapp.presentation.di.favorite.FavoriteSubComponent

interface Injector {

    fun createBeerSubComponent(): BeerSubComponent

    fun createFavoriteSubComponent(): FavoriteSubComponent
}