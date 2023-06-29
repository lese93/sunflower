package com.example.myapplication

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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
        /**
         * 1 version
         * name | image_url | watering | description
         *
         * 2 version
         * name | image_url | watering | description | favorite
         *
         * 3 version
         * name | watering | description | favorite
         * */
        // Room DB 테이블 정합성이 맞지 않을때
        // 1 version to 2 version
        val migrations1to2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE plant ADD COLUMN favorite INTEGER DEFAULT 0 NOT NULL")
            }
        }

        val migrations2to3 = object : Migration(2, 3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE plant REMOVE COLUMN image_url")
            }
        }


        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "plant.db")
            .addMigrations(migrations1to2)
            .addMigrations(migrations2to3)
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