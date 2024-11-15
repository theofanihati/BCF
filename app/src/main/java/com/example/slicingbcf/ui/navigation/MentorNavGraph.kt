package com.example.slicingbcf.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.slicingbcf.implementation.mentor.penilaian_peserta.DetailPenilaianPesertaScreen
import com.example.slicingbcf.implementation.mentor.penilaian_peserta.PenilaianPesertaScreen

fun NavGraphBuilder.mentorNavGraph(
  modifier : Modifier,
  navController : NavHostController
) {
  navigation(
    startDestination = Screen.Mentor.DetailPenilaianPeserta("1").route, route = "mentor"
  ) {
    composable(
      route = Screen.Mentor.PenilaianPeserta.route
    ) {

      val onNavigateDetailPenilaianPeserta = { id : String ->
        navController.navigate("penilaian-peserta/$id")
      }

      PenilaianPesertaScreen(
        modifier = modifier,
        onNavigateDetailPenilaianPeserta = onNavigateDetailPenilaianPeserta
      )
    }
    composable(
      route = "penilaian-peserta/{id}",
      arguments = listOf(navArgument("id") { type = NavType.StringType })
    ) {


      DetailPenilaianPesertaScreen(
        modifier = modifier,
        id = it.arguments?.getString("id") ?: "1"
      )
    }
  }


}