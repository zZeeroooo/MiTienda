package com.example.mitienda.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mitienda.ui.viewmodel.MainViewModel

@Composable
fun ProductosScreen(
    viewModel: MainViewModel
) {
    val productos by viewModel.productos.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Productos disponibles")

        productos.forEach { producto ->
            Text(text = "${producto.nombre} - $${producto.precio}")
        }
    }
}