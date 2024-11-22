package com.example.slicingbcf.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.slicingbcf.implementation.mentor.penilaian_peserta.PenilaianPesertaScreen
import com.example.slicingbcf.implementation.peserta.form_feedback_mini_training.FormMiniTrainingScreen
import com.example.slicingbcf.implementation.peserta.jadwal.bulanan.JadwalMentoringBulanScreen
import com.example.slicingbcf.implementation.peserta.jadwal.mingguan.JadwalMentoringMingguScreen
import com.example.slicingbcf.implementation.peserta.pitch_deck.PitchDeckPesertaScreen

fun NavGraphBuilder.kegiatanNavGraph(
    modifier : Modifier,
    navController : NavHostController
) {
    navigation(
        startDestination = Screen.Kegiatan.UmpanBalikKegiatan.route, route = "kegiatan"
    ) {
        composable(
            route = Screen.Kegiatan.UmpanBalikKegiatan.route
        ) {
            FormMiniTrainingScreen(
                modifier = modifier
            )
        }
    }

//    composable(
//        route = "jadwal-bulan/$id",
//        arguments = listOf(navArgument("id") { type = NavType.StringType })
//    ) { backStackEntry ->
//        val id = backStackEntry.arguments?.getString("id") ?: ""
//        if (id.isEmpty()) throw IllegalStateException("id must not be empty")
//
//        val onNavigateWeeklyCalendar = { id : String ->
//            navController.navigateSingleTop("jadwal-minggu/$id")
//        }
//
//        JadwalMentoringBulanScreen(
//            modifier = modifier,
//            onNavigateWeeklyCalendar = onNavigateWeeklyCalendar
//        )
//    }

    composable(
        route = Screen.Kegiatan.JadwalMentoringBulan.route,
    ) {
        val onNavigateWeeklyCalendar = { id : String ->
            navController.navigateSingleTop("jadwal-minggu/$id")
        }

        JadwalMentoringBulanScreen(
            modifier = modifier,
            onNavigateWeeklyCalendar = onNavigateWeeklyCalendar
        )
    }
    composable(
        route = "jadwal-minggu/$id",
        arguments = listOf(navArgument("id") { type = NavType.StringType })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id") ?: ""
        if (id.isEmpty()) throw IllegalStateException("id must not be empty")

        val onNavigateMonthlyCalendar = { id : String ->
            navController.navigateSingleTop("jadwal-bulan")
        }

        JadwalMentoringMingguScreen(
            modifier = modifier,
            onNavigateMonthlyCalendar = onNavigateMonthlyCalendar
        )
    }
}