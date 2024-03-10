package com.ronit.reptracker.routine.presentation.Routine

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ronit.reptracker.core.presentation.TopBar
import com.ronit.reptracker.routine.domain.model.RoutineDto
import com.ronit.reptracker.routine.presentation.Routine.compoenets.ExerciseRow
import com.ronit.reptracker.routine.presentation.Routine.event.SingleRoutineScreenEvent
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleRoutineScreen(
    viewModel: SingleRoutineViewModel= hiltViewModel() ,
    navController: NavController,
    routineId:Int?
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val coroutineScope = rememberCoroutineScope()

    val bottomSheetState = rememberModalBottomSheetState()


    var showBottomSheet by remember {
        mutableStateOf(false)
    }




    LaunchedEffect(true) {

        routineId?.let {

         viewModel.onEvent(SingleRoutineScreenEvent.GetRoutine(it))
        }



    }




    if(showBottomSheet) {


        ExerciseListBottomSheet(
                modalBottomSheetState = bottomSheetState,
                viewModel = viewModel,
                routineId = viewModel.state.routine.routineId

        ) {

           showBottomSheet=false

        }
    }



    Scaffold(
            topBar = { TopBar(
                    textAction = null,
                    title = if (viewModel.state.routine.routineName.isBlank())"Demo title" else viewModel.state.routine.routineName,
                    iconAction =null ,
                    scrollBehavior =scrollBehavior ,
                    onBackNavigate = {

                             viewModel.onEvent(SingleRoutineScreenEvent.OnBackNavigate{
                                 navController.popBackStack()
                             })
                    },
                    onTextActionClick = {
                       TODO("Save Routine Function Not Implemented")
                    }) {

            }
            }
    ) {



        Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(all = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
            ) {
                
                TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        value = viewModel.state.routine.routineName,
                        textStyle = TextStyle(
                                fontSize = 20.sp
                        ),
                        placeholder = { Text(text = "Name")},
                        onValueChange = {

                               viewModel.onEvent(SingleRoutineScreenEvent.OnRoutineNameEntered(it))
                        },
                        singleLine = true,

                        )
            }

            Spacer(modifier = Modifier.height(40.dp))

            var isAddExerciseBtnEnabled by remember {
                mutableStateOf(true)
            }

            TextButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(start = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    enabled =isAddExerciseBtnEnabled ,
                    onClick = {
                        showBottomSheet=true
                    }
            ) {
                Text(
                        text = "Add Exercise",
                        fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                    modifier = Modifier.fillMaxSize()
            ) {

                items(
                    items = viewModel.state.exerciseList,
                ){
                    ExerciseRow(exerciseName = it.name) {
                        viewModel.onEvent(SingleRoutineScreenEvent.AddExerciseToRoutine(it,viewModel.state.routine.routineId))
                    }
                }
            }
        }
    }
}

//@Preview(name = "Add Routine Screen" , showBackground = true)
//@Composable
//private fun Preview() {
//    RoutineScreen(viewModel = RoutineViewModel(),rememberNavController(),"","")
//}