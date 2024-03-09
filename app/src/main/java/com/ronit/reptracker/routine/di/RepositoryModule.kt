package com.ronit.reptracker.routine.di

import com.ronit.reptracker.core.database.RepCounterDatabase
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
    fun provideRoutineRepositoryImpl(db:RepCounterDatabase):RoutineRepository{

        return RoutineRepositoryImpl(db)
    }
}