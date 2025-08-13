package com.dakode.kuymabar.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val internalNavController = rememberNavController()
    var selectedItem by remember { mutableStateOf(0) }
    
    val items = listOf(
        NavigationItem("lobi", "Lobi", Icons.Default.Home),
        NavigationItem("jelajah", "Jelajah", Icons.Default.Search),
        NavigationItem("jadwal", "Jadwal", Icons.Default.DateRange),
        NavigationItem("profil", "Profil", Icons.Default.Person)
    )
    
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.title) },
                            label = { Text(item.title) },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                internalNavController.navigate(item.route) {
                                    popUpTo(internalNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            // TODO: Implementasi untuk FAB
                        }
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Tambah"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = internalNavController,
            startDestination = "lobi",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("lobi") {
                HomeScreen()
            }
            composable("jelajah") {
                Text("Halaman Jelajah")
            }
            composable("jadwal") {
                Text("Halaman Jadwal")
            }
            composable("profil") {
                Text("Halaman Profil")
            }
        }
    }
}

data class NavigationItem(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
