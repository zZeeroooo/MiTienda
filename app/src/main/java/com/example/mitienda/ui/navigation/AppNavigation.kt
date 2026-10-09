package com.example.mitienda.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mitienda.ui.screen.HomeScreen
import com.example.mitienda.ui.screen.PerfilScreen
import com.example.mitienda.ui.screen.ProductosScreen
import com.example.mitienda.ui.viewmodel.MainViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Tienda") }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentRoute == AppRoutes.HOME,
                    onClick = { navController.navigate(AppRoutes.HOME) },
                    icon = {Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Inicio"
                    )},
                    label = { Text("Inicio") }
                )
                NavigationBarItem(
                    selected = currentRoute == AppRoutes.PRODUCTOS,
                    onClick = { navController.navigate(AppRoutes.PRODUCTOS) },
                    icon = {Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Productos"
                    )},
                    label = { Text("Productos") }
                )
                NavigationBarItem(
                    selected = currentRoute == AppRoutes.PERFIL,
                    onClick = { navController.navigate(AppRoutes.PERFIL) },
                    icon = {Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Perfil"
                    )},
                    label = { Text("Perfil") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppRoutes.HOME,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(AppRoutes.HOME) {
                HomeScreen()
            }
            composable(AppRoutes.PRODUCTOS) {
                ProductosScreen(viewModel = viewModel)
            }
            composable(AppRoutes.PERFIL) {
                PerfilScreen()
            }
        }
    }
}