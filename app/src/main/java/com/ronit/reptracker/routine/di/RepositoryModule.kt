package com.ronit.reptracker.routine.di

import com.ronit.reptracker.core.database.Database
import com.ronit.reptracker.routine.data.repository.RoutineRepositoryImpl
import com.ronit.reptracker.routine.domain.repository.RoutineRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    @RoutineRepositoryImplQualifier
    fun provideRoutineRepositoryImpl(db:Database):RoutineRepository{

        return RoutineRepositoryImpl(db)
    }
}