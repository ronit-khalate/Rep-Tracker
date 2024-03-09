package com.ronit.reptracker.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    textAction:String?,
    title:String,
    iconAction:ImageVector?,
    scrollBehavior: TopAppBarScrollBehavior,
    isBackNavigationButtonEnabled:Boolean=true,
    onBackNavigate:()->Unit,
    onTextActionClick:()->Unit,
    onIconActionClick:()->Unit
) {


    MediumTopAppBar(
            scrollBehavior=scrollBehavior,
            title = {

                Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                )
            },


            navigationIcon = {

                if (isBackNavigationButtonEnabled){

                    IconButton(onClick = onBackNavigate) {
                        Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Go Back"
                        )
                    }
                }
            },

            actions = {

                textAction?.let {

                    TextButton(onClick = { /*TODO*/ }) {

                        Text(
                                text = textAction
                        )
                    }
                }
                iconAction?.let {icon->

                    IconButton(onClick = onIconActionClick) {
                        Icon(
                                imageVector = icon,
                                contentDescription = title
                        )
                    }

                }
            }

    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Top Bar", showBackground = true)
@Composable
private fun Preview() {
    TopBar(textAction = "Demo", title = "Demo Name", iconAction =Icons.Default.Add, scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior() , onIconActionClick = {}, onBackNavigate = {}, onTextActionClick = {})
}