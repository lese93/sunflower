package com.example.myapplication

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Singleton
    @Provides
    fun provideMyGardenRepository(): MyGardenRepository {
        return MyGardenRepository()
    }

    @Singleton
    @Provides
    fun providePlantListRepository(): PlantListRepository {
        return PlantListRepository()
    }
}