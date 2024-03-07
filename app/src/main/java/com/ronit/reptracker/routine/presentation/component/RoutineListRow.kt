package com.ronit.reptracker.routine.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RoutineListRow() {

    Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 10.dp, end = 10.dp)
               .height(50.dp)
               .clickable {  },
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
                text = "Routine_name",
                fontSize = 16.sp
        )

        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")

    }
}

@Preview(name = "Routine List Row", showBackground = true)
@Composable
private fun Preview() {

    RoutineListRow()
}