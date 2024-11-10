package com.example.slicingbcf.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.slicingbcf.implementation.LandingPageScreen

@Composable
fun NavGraph(
  navController : NavHostController,
  startDestination : String = "peserta",
  modifier : Modifier,
) {
  NavHost(navController = navController, startDestination = startDestination) {
    composable(Screen.Home.route) {
      LandingPageScreen(
        modifier = modifier,
      )
    }
    authNavGraph(
      modifier = modifier,
      navController = navController
    )
    pesertaNavGraph(
      modifier = modifier,
      navController = navController
    )
  }
}
