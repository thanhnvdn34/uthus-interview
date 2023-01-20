package com.thanhnvdn34.uthusapp.presentation.di.favorite

import com.thanhnvdn34.uthusapp.presentation.beer.BeerActivity
import com.thanhnvdn34.uthusapp.presentation.favorite.FavoriteActivity
import dagger.Subcomponent

@FavoriteScope
@Subcomponent(modules = [FavoriteModule::class])
interface FavoriteSubComponent {

    fun inject(favoriteActivity: FavoriteActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():FavoriteSubComponent
    }
}