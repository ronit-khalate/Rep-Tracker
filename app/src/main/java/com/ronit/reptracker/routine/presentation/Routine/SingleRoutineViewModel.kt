package com.ronit.reptracker.routine.presentation.Routine

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronit.reptracker.routine.data.local_datasource.model.toExerciseDto
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import com.ronit.reptracker.routine.domain.model.RoutineExerciseCrossRefDto
import com.ronit.reptracker.routine.domain.usecase.AddExerciseToRoutineUseCase
import com.ronit.reptracker.routine.domain.usecase.ChangeRoutineNameUseCase
import com.ronit.reptracker.routine.domain.usecase.CreateNewRoutineUseCase
import com.ronit.reptracker.routine.domain.usecase.GetAllExerciseUseCase
import com.ronit.reptracker.routine.domain.usecase.GetAllRoutineWithExercisesUsecase
import com.ronit.reptracker.routine.domain.usecase.GetExerciseByIdUseCase
import com.ronit.reptracker.routine.domain.usecase.GetRoutineUseCase
import com.ronit.reptracker.routine.presentation.Routine.event.SingleRoutineScreenEvent
import com.ronit.reptracker.routine.presentation.Routine.state.SingleRoutineScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleRoutineViewModel @Inject constructor(
        private val getRoutineUseCase: GetRoutineUseCase,
        private val getAllRoutineWithExercisesUsecase: GetAllRoutineWithExercisesUsecase,
        private val getAllExerciseUseCase: GetAllExerciseUseCase,
        private val addExerciseToRoutine:AddExerciseToRoutineUseCase,
        private val createNewRoutineUseCase: CreateNewRoutineUseCase,
        private val getExerciseByIdUseCase: GetExerciseByIdUseCase,
        private val changeRoutineNameUseCase: ChangeRoutineNameUseCase
):ViewModel() {

    var state by mutableStateOf<SingleRoutineScreenState>(SingleRoutineScreenState())
        private set

    var isStatedChanged by mutableStateOf(false)

    var allExercises by mutableStateOf<List<ExerciseDto>>(emptyList())

    init {

        viewModelScope.launch {

            getAllExerciseUseCase().collect{
                allExercises=it.map {
                    it.toExerciseDto()
                }

            }
        }
    }

    init {

    }



    @OptIn(ExperimentalMaterialApi::class)
    fun onEvent(event:SingleRoutineScreenEvent){

        when(event){
            is SingleRoutineScreenEvent.GetRoutine -> {
                getRoutine(event.routineId)
            }
            is SingleRoutineScreenEvent.OnAddExercisedBtnClicked -> TODO()
            is SingleRoutineScreenEvent.OnBackNavigate -> {onBackNavigate(event)}
            is SingleRoutineScreenEvent.OnRoutineNameEntered ->{
                onStateChange {
                    state=state.copy(routine = state.routine.copy(routineName = event.name))
                }
            }
            is SingleRoutineScreenEvent.SaveRoutine -> TODO()

            is SingleRoutineScreenEvent.AddExerciseToRoutine -> {
                addExerciseToRoutine(event.exercise,event.routineId)
            }

            is SingleRoutineScreenEvent.CreateNewRoutine -> {
                viewModelScope.launch { createNewRoutineUseCase(event.routineDto) }
            }
        }
    }


    private fun onStateChange(
        change:()->Unit
    ){
        change()

        isStatedChanged=true

    }

    private fun getRoutine(routineId:Int){
        viewModelScope.launch {
            val routineWithExercises=getAllRoutineWithExercisesUsecase().find {
                it.routineId==routineId
            }!!

            val routine = getRoutineUseCase(routineWithExercises.routineId)

            onStateChange {


                state= state.copy(
                        routine = routine,
                        exerciseList = routineWithExercises.exercises

                )
            }
        }
    }

    private fun addExerciseToRoutine(exercise:ExerciseDto,routineId: Int){
        viewModelScope.launch {

            val routineExerciseCrossRef =RoutineExerciseCrossRefDto(
                    routineId = routineId,
                    exerciseId = exercise.exerciseId
            )
            addExerciseToRoutine(routineExerciseCrossRef)
            val addedExercise = getExerciseByIdUseCase(routineExerciseCrossRef.exerciseId)

            onStateChange {

                state=state.copy(exerciseList = state.exerciseList + listOf(addedExercise))
            }


        }
    }

    private fun onBackNavigate(event:SingleRoutineScreenEvent.OnBackNavigate){
        viewModelScope.launch {
            changeRoutineNameUseCase(state.routine)
        }.invokeOnCompletion {
            event.onSavingCompleted()
        }
    }

}