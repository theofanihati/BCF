package com.example.slicingbcf.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.slicingbcf.implementation.peserta.data_peserta.DataPesertaScreen
import com.example.slicingbcf.implementation.peserta.kelompok_mentoring.KelompokMentoringScreen
import com.example.slicingbcf.implementation.peserta.pengumuman_peserta.DetailPengumumanPesertaScreen
import com.example.slicingbcf.implementation.peserta.pengumuman_peserta.PengumumanPesertaScreen
import com.example.slicingbcf.implementation.peserta.worksheet_peserta.DetailWorksheetPesertaScreen
import com.example.slicingbcf.implementation.peserta.worksheet_peserta.WorksheetPesertaScreen


fun NavGraphBuilder.pesertaNavGraph(
  modifier : Modifier,
  navController : NavHostController
) {
  navigation(startDestination = Screen.Peserta.DataPeserta.route, route = "peserta") {
    composable(Screen.Peserta.DataPeserta.route) {
      DataPesertaScreen(
        modifier = modifier,
      )
    }
    composable(Screen.Peserta.KelompokMentoring.route) {
      KelompokMentoringScreen(
        modifier = modifier,
      )
    }
    composable(Screen.Peserta.PengumumanPeserta.route) {
      PengumumanPesertaScreen(
        modifier = modifier,
      )
    }
    composable(
      route = "pengumuman-peserta/{id}",
      arguments = listOf(navArgument("id") { type = NavType.StringType })
    ) { backStackEntry ->
      val id = backStackEntry.arguments?.getString("id") ?: ""
      if (id.isEmpty()) throw IllegalStateException("id must not be empty")
      DetailPengumumanPesertaScreen(modifier = modifier, id = id)
    }
    composable(Screen.Peserta.WorksheetPeserta.route) {
      WorksheetPesertaScreen(
        modifier = modifier,
      )
    }
    composable(
      route = "worksheet-peserta/{id}",
      arguments = listOf(navArgument("id") { type = NavType.StringType })
    ) { backStackEntry ->
      val id = backStackEntry.arguments?.getString("id") ?: ""
      if (id.isEmpty()) throw IllegalStateException("id must not be empty")
      DetailWorksheetPesertaScreen(modifier = modifier, id = id)
    }


  }
}
