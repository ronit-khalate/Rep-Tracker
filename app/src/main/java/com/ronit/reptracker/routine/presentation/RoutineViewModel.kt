package com.ronit.reptracker.routine.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronit.reptracker.routine.data.local_datasource.model.toExerciseDto
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineEntity
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import com.ronit.reptracker.routine.domain.model.RoutineDto
import com.ronit.reptracker.routine.domain.usecase.AddExerciseToRoutineUseCase
import com.ronit.reptracker.routine.domain.usecase.AddRoutineUseCase
import com.ronit.reptracker.routine.domain.usecase.GetAllExerciseUseCase
import com.ronit.reptracker.routine.domain.usecase.GetAllRoutineUseCase
import com.ronit.reptracker.routine.domain.usecase.GetRoutineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(
        private val addRoutineUseCase: AddRoutineUseCase,
        private val getAllRoutineUseCase: GetAllRoutineUseCase,
        private val getRoutineUseCase: GetRoutineUseCase,
        private val getAllExerciseUseCase: GetAllExerciseUseCase,
        private val addExerciseToRoutine: AddExerciseToRoutineUseCase
):ViewModel() {

        var allRoutines :MutableState<List<RoutineDto>> = mutableStateOf(emptyList())
                private set



        var allExercises:MutableState<List<ExerciseDto>> = mutableStateOf(emptyList())
                private set
        val routine = mutableStateOf(RoutineDto(0))
        init {
            viewModelScope.launch {
                    getAllExerciseUseCase().collect{list->
                           allExercises.value=list.map{
                                   it.toExerciseDto()
                           }
                    }
            }
        }


        init {



                viewModelScope.launch {
                        getAllRoutineUseCase().collect{
                                allRoutines.value=it
                        }

                }
        }

        fun onEvent(event: RoutinesScreenEvent){

                when(event){

                        is RoutinesScreenEvent.RoutineListScreenEvent->{

                                when(event){
                                        is RoutinesScreenEvent.RoutineListScreenEvent.OnRoutineClicked->{

                                                TODO()
                                        }

                                }
                        }

                        is RoutinesScreenEvent.RoutineScreenEvent->{

                                when(event){
                                        is RoutinesScreenEvent.RoutineScreenEvent.SaveRoutine -> {
                                                viewModelScope.launch {
                                                        addRoutineUseCase(
                                                                event.routine.toRoutineEntity()
                                                        )
                                                }

                                        }

                                        is RoutinesScreenEvent.RoutineScreenEvent.GetRoutine ->{
                                                viewModelScope.launch {

                                                        val routine = getRoutineUseCase(event.id)

                                                        event.onGotten(routine)

                                                }
                                        }

                                        is RoutinesScreenEvent.RoutineScreenEvent.AddExercise -> {


                                        }

                                        is RoutinesScreenEvent.RoutineScreenEvent.OnExerciseClicked -> {

                                                viewModelScope.launch {

                                                        addExerciseToRoutine(event.routineExerciseCrossRefDto)
                                                }
                                        }
                                }
                        }
                }
        }

}