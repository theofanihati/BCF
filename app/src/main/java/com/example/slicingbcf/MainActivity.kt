package com.example.slicingbcf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.slicingbcf.implementation.peserta.worksheet_peserta.DetailWorksheetPeserta
import com.example.slicingbcf.ui.shared.MainScaffold
import com.example.slicingbcf.ui.theme.SlicingBcfTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SlicingBcfTheme {
<<<<<<< HEAD
        MainScaffold() { paddingValues ->
          DetailWorksheetPeserta(
=======

        MainScaffold(
          config = scaffoldConfig(currentRoute),
          isActiveRoute = ::isActiveRoute,
          navController = navController,
        ) { paddingValues ->
          NavGraph(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
>>>>>>> source-repo/main
          )
        }
      }
    }
  }
}
