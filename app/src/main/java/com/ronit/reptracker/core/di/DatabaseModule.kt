package com.ronit.reptracker.core.di

import android.content.Context
import androidx.room.Room

import com.ronit.reptracker.core.database.Database
import com.ronit.reptracker.core.utility.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context):Database{

        return Room.databaseBuilder(
                context=context,
                Database::class.java,
                Constants.DATABASE_NAME
        ).build()
    }
}