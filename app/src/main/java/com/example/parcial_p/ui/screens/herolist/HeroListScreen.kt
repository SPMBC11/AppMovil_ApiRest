package com.example.parcial_p.ui.screens.herolist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HeroListScreen(
    state: StateFlow<HeroListUIState>,
    onHeroClick: (Int) -> Unit,
    onRefresh: () -> Unit
) {
    val ui = state.collectAsStateWithLifecycle().value

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        when {
            ui.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            ui.errorMessage != null -> {
                Text(text = ui.errorMessage ?: "Error", modifier = Modifier.align(Alignment.Center))
            }
            else -> {
                LazyColumn {
                    items(ui.heroes) { hero ->
                        HeroCard(hero = hero, onClick = { onHeroClick(hero.id) })
                    }
                }
            }
        }
    }
}