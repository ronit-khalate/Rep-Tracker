package com.ronit.reptracker.core.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

   BottomNavigation(
           modifier = Modifier
               .fillMaxWidth(),

   ) {

       Screens.screens.forEach {screen->

           BottomNavigationItem(
                   selected =  currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                   onClick = {
                       navController.navigate(screen.route) {
                       // Pop up to the start destination of the graph to
                       // avoid building up a large stack of destinations
                       // on the back stack as users select items
                       popUpTo(navController.graph.findStartDestination().id) {
                           saveState = true
                       }
                       // Avoid multiple copies of the same destination when
                       // reselecting the same item
                       launchSingleTop = true
                       // Restore state when reselecting a previously selected item
                       restoreState = true
                   }},
                   icon = { Icon(imageVector = screen.icon!!, contentDescription = screen.name) }
           )

       }
   }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {

    BottomBar(rememberNavController())
}