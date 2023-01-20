package com.thanhnvdn34.uthusapp.presentation.di.core

import android.content.Context
import com.thanhnvdn34.uthusapp.presentation.di.beer.BeerSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [BeerSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}