package com.thanhnvdn34.uthusapp.presentation.di.beer

import com.thanhnvdn34.uthusapp.presentation.beer.BeerActivity
import dagger.Subcomponent

@BeerScope
@Subcomponent(modules = [BeerModule::class])
interface BeerSubComponent {

    fun inject(beerActivity: BeerActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():BeerSubComponent
    }
}