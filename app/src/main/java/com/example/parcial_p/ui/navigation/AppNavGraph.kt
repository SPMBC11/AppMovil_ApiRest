package com.example.parcial_p.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial_p.ui.screens.herolist.HeroListScreen
import com.example.parcial_p.ui.screens.herolist.HeroListViewModel
import com.example.parcial_p.ui.screens.herodetail.HeroDetailScreen
import com.example.parcial_p.ui.screens.herodetail.HeroDetailViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "hero_list") {
        composable("hero_list") {
            val vm: HeroListViewModel = hiltViewModel()
            val state = vm.uiState
            HeroListScreen(
                state = state,
                onHeroClick = { id -> navController.navigate("hero_detail/$id") },
                onRefresh = { vm.loadAllHeroes() }
            )
        }
        composable(
            route = "hero_detail/{heroId}",
            arguments = listOf(navArgument("heroId") { type = NavType.IntType })
        ) {
            val vm: HeroDetailViewModel = hiltViewModel()
            val state = vm.uiState
            HeroDetailScreen(state = state.value)
        }
    }
}