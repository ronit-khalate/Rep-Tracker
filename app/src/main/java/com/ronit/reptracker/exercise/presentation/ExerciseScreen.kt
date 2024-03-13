package com.ronit.reptracker.exercise.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ronit.reptracker.core.presentation.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen(
    viewModel :ExerciseViewModel= hiltViewModel(),
    navController: NavController
) {



    val topBarScrollBehavior=TopAppBarDefaults.enterAlwaysScrollBehavior()
    val snackbarHostState= remember {
        SnackbarHostState()
    }
    Scaffold(

            topBar = {
                TopBar(
                        textAction = "Save",
                        title ="Add Exercise",
                        iconAction =null ,
                        scrollBehavior = topBarScrollBehavior,
                        onBackNavigate = {

                             viewModel.onBackNavigate(snackbarHostState){
                                 navController.popBackStack()
                             }

                        },
                        onTextActionClick = {
                            viewModel.onSave(snackbarHostState){
                                navController.popBackStack()
                            }
                        }) {

                }
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
    ){

        Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                    modifier = Modifier
                        .padding(start = 5.dp,end=5.dp)
            ) {


                TextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = viewModel.state.exerciseName,
                        label = { Text(text = "Exercise Name")},
                        onValueChange = {
                                        viewModel.onExerciseNameEntered(it)
                        },
                        shape = RoundedCornerShape(20.dp)
                )
            }

        }
    }
}


