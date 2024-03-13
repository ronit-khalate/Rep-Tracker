package com.ronit.reptracker.exercise.di

import androidx.core.location.LocationRequestCompat.Quality
import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.exercise.data.repository.ExerciseRepositoryImpl
import com.ronit.reptracker.exercise.domain.repository.ExerciseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ExerciseRepositoryImplQulifier
    fun provideExerciseRepoImpl(
        db:RepCounterDatabase
    ):ExerciseRepository{
        return ExerciseRepositoryImpl(db)
    }

}

@Quality
annotation class ExerciseRepositoryImplQulifier