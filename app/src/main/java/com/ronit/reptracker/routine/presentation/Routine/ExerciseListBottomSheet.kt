package com.ronit.reptracker.routine.presentation.Routine

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.coroutineScope
import com.ronit.reptracker.routine.presentation.Routine.compoenets.ExerciseRow
import com.ronit.reptracker.routine.presentation.Routine.event.SingleRoutineScreenEvent
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseListBottomSheet(
    modalBottomSheetState: SheetState,
    viewModel: SingleRoutineViewModel,
    routineId: Int,
    onDismissRequest: () -> Unit,
){

    val lazyListState = rememberLazyListState()
    val scope = rememberCoroutineScope()



    ModalBottomSheet(
            modifier = Modifier
                .fillMaxSize(),
            onDismissRequest ={ onDismissRequest() },
            sheetState = modalBottomSheetState,
    ) {

        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
        ) {


            Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(onClick = onDismissRequest) {

                    Text("Cancel")

                }

                Text(
                        text = "Select Exercise",
                        fontWeight = FontWeight.Bold
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                            imageVector = Icons.Filled.Add,
                            contentDescription = ""
                    )
                }
            }

            // search bar

            TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                            fontSize = 50.sp
                    ),
                    value = "",
                    onValueChange ={},
                    leadingIcon = {
                        Image(imageVector = Icons.Filled.Search, contentDescription ="" )
                    },

            )

            Spacer(modifier = Modifier.height(10.dp))

            // list

            LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    state = lazyListState

            ) {

                items(
                        items =viewModel.allExercises ,
                        key = { it.exerciseId }
                ){

                    ExerciseRow(exerciseName = it.name){
                        viewModel.onEvent(
                                SingleRoutineScreenEvent.AddExerciseToRoutine(it,routineId){
                                    scope.launch {

                                         modalBottomSheetState.hide()
                                    }
                                }
                        )

                    }

                }
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@Preview(showBackground = true)
//private fun Preview() {
//
//    ExerciseListBottomSheet(rememberStandardBottomSheetState(),{})
//
//}