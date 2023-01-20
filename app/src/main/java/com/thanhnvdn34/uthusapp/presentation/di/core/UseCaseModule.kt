package com.thanhnvdn34.uthusapp.presentation.di.core

import com.thanhnvdn34.uthusapp.domain.repository.DataRepository
import com.thanhnvdn34.uthusapp.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetBeersUseCase(dataRepository: DataRepository): GetBeersUseCase {
        return GetBeersUseCase(dataRepository)
    }

    @Provides
    fun provideGetBeersFromDBUseCase(dataRepository: DataRepository): GetBeersFromDBUseCase {
        return GetBeersFromDBUseCase(dataRepository)
    }

    @Provides
    fun provideSaveBeersToDBUseCase(dataRepository: DataRepository): SaveBeersToDBUseCase {
        return SaveBeersToDBUseCase(dataRepository)
    }

    @Provides
    fun provideSaveBeerToDBUseCase(dataRepository: DataRepository): SaveBeerToDBUseCase {
        return SaveBeerToDBUseCase(dataRepository)
    }

    @Provides
    fun provideUpdateBeerUseCase(dataRepository: DataRepository): UpdateBeerUseCase {
        return UpdateBeerUseCase(dataRepository)
    }

    @Provides
    fun provideDeleteBeerUseCase(dataRepository: DataRepository): DeleteBeerUseCase {
        return DeleteBeerUseCase(dataRepository)
    }

    @Provides
    fun provideClearAllUseCase(dataRepository: DataRepository): ClearAllUseCase {
        return ClearAllUseCase(dataRepository)
    }

}