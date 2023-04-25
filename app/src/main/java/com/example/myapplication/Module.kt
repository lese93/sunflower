package com.example.myapplication

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.PlantDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
               "plant.db")
            .build()
    }

    @Singleton
    @Provides
    fun providePlantDAO(plantDB: AppDatabase): PlantDAO {
        return plantDB.plantDAO()
    }

    @Singleton
    @Provides
    fun provideMyGardenRepository(plantDAO: PlantDAO): MyGardenRepository {
        return MyGardenRepository(plantDAO)
    }

    @Singleton
    @Provides
    fun providePlantListRepository(plantDAO: PlantDAO): PlantListRepository {
        return PlantListRepository(plantDAO)
    }
}