package com.example.slicingbcf.implementation.peserta.worksheet_peserta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText

// TODO: RAPIHIN LAYOUT + TAMBAHIN ITEMS ITEMS LAINNYA YANG ADA DI COLUMN JUDUL DLL
@Composable
@Preview(showSystemUi = true)
fun DetailWorksheetPeserta() {
  Column {
    Text(
      text = "Submisi Lembar Kerja",
      style = StyledText.MobileLargeMedium,
    )
    Column {
      Text(
        text = "Judul Lembar Kerja",
        style = StyledText.MobileBaseSemibold,
      )
      Text(
        text = "[Capacity Building] Hari Ke-4 Lembar Kerja - Topik: Sustainability and Sustainable Development Kerja",
        style = StyledText.MobileBaseRegular,
      )
    }
    Column {
      Text(
        text = "Judul Lembar Kerja",
        style = StyledText.MobileBaseSemibold,
      )
      Text(
        text = "[Capacity Building] Hari Ke-4 Lembar Kerja - Topik: Sustainability and Sustainable Development Kerja",
        style = StyledText.MobileBaseRegular,
      )
    }
    HorizontalDivider()
    Row {
      Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
          containerColor = ColorPalette.PrimaryColor700,
        ),

        ) {
        Text(
          text = "Simpan",
          style = StyledText.MobileSmallMedium,
        )
      }
      OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
          contentColor = ColorPalette.PrimaryColor700,
        ),
      ) {
        Text(
          text = "Batal",
          style = StyledText.MobileSmallRegular,
          color = ColorPalette.PrimaryColor700
        )
      }
    }
  }
}