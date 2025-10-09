package com.example.parcial_p.ui.screens.herodetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HeroDetailScreen(state: HeroDetailUIState, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().padding(16.dp)) {
        when {
            state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            state.errorMessage != null -> Text(text = state.errorMessage ?: "Error", modifier = Modifier.align(Alignment.Center))
            state.hero != null -> {
                val h = state.hero
                Column(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = h.imageUrlLarge,
                        contentDescription = h.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = h.name)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Nombre real: ${h.fullName}")
                    Text(text = "Editorial: ${h.publisher}")
                    h.biography?.let { Text(text = "Aliases: $it") }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "Powerstats")
                    h.powerstats.forEach { (k, v) ->
                        Text(text = "$k: ${v ?: 0}")
                    }
                }
            }
        }
    }
}