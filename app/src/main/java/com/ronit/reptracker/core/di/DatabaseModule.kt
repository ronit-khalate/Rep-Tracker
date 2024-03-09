package com.ronit.reptracker.core.di

import android.content.Context
import androidx.room.Room

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.core.utility.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):RepCounterDatabase{

        return Room.databaseBuilder(
                context=context,
                RepCounterDatabase::class.java,
                Constants.DATABASE_NAME
        ).build()
    }
}