package com.example.slicingbcf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.slicingbcf.implementation.peserta.data_peserta.DataPesertaScreen
import com.example.slicingbcf.ui.shared.MainScaffold
import com.example.slicingbcf.ui.theme.SlicingBcfTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SlicingBcfTheme {
        MainScaffold() { paddingValues ->
          DataPesertaScreen(
            modifier = Modifier.padding(
              top = paddingValues.calculateTopPadding(),
              bottom = paddingValues.calculateBottomPadding()
            )
          )
        }
      }
    }
  }
}
