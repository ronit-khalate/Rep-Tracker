package com.ronit.reptracker.exercise.presentation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronit.reptracker.exercise.domain.usescases.AddExerciseUseCase
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
        private val addExerciseUseCase: AddExerciseUseCase
):ViewModel() {

    var state by mutableStateOf(ExerciseScreenState())
        private set

    fun onExerciseNameEntered(name:String){

        state=state.copy(exerciseName =name)
    }

    fun onSave(snackBarHostState: SnackbarHostState,onSaveDone:()->Unit){

        if(state.exerciseName.isBlank()){

            viewModelScope.launch {
                snackBarHostState.showSnackbar(
                        message = "You must enter a name for the exercise",

                )
            }
        }
        else{

            try {
                viewModelScope.launch {
                    val exercise= ExerciseDto(name = state.exerciseName, exerciseId = 0)
                    addExerciseUseCase(exercise)
                }.invokeOnCompletion {
                    onSaveDone()
                }
            }
            catch (e:Exception){

                viewModelScope.launch {


                    snackBarHostState.showSnackbar(
                            "Something went wrong"
                    )
                }
            }



        }
    }

    fun onBackNavigate(snackBarHostState: SnackbarHostState,onNavigate:()->Unit){

        if(state.exerciseName.isNotBlank()){

            viewModelScope.launch {

                val result=snackBarHostState.showSnackbar(
                        "Exercise Will Not Be saved",
                        actionLabel = "Don't Save"
                )

                when(result){
                    SnackbarResult.Dismissed -> {}
                    SnackbarResult.ActionPerformed -> {
                        onNavigate()
                    }
                }
            }
        }
        else{
            onNavigate()
        }

    }
}