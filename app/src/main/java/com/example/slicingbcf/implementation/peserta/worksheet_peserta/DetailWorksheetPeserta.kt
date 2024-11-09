package com.example.slicingbcf.implementation.peserta.worksheet_peserta

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.outlinedButtonBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.shared.CustomOutlinedTextField

// TODO: RAPIHIN LAYOUT + TAMBAHIN ITEMS ITEMS LAINNYA YANG ADA DI COLUMN JUDUL DLL
@Composable
fun DetailWorksheetPesertaScreen(
  modifier : Modifier = Modifier,
  id : String
) {
  Column(
    modifier = modifier.padding(
      horizontal = 16.dp
    ),
    verticalArrangement = Arrangement.spacedBy(36.dp),
  ) {
    Text(
      text = "Submisi Lembar Kerja",
      style = StyledText.MobileLargeMedium,
      color = ColorPalette.Black,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center,
    )
    Column(
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Text(
        text = "Judul Lembar Kerja",
        style = StyledText.MobileBaseSemibold,
        color = ColorPalette.PrimaryColor700
      )
      Text(
        text = "[Capacity Building] Hari Ke-4 Lembar Kerja - Topik: Sustainability and Sustainable Development Kerja",
        style = StyledText.MobileBaseRegular,
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Text(
        text = "Judul Lembar Kerja",
        style = StyledText.MobileBaseSemibold,
        color = ColorPalette.PrimaryColor700
      )
      Text(
        text = "[Capacity Building] Hari Ke-4 Lembar Kerja - Topik: Sustainability and Sustainable Development Kerja",
        style = StyledText.MobileBaseRegular,
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Text(
        text = "Tautan Lembar Kerja",
        style = StyledText.MobileBaseSemibold,
        color = ColorPalette.PrimaryColor700
      )
      Text(
        text = "bit.ly/LembarKerjaMiniTrainingDay5",
        style = StyledText.MobileBaseRegular,
        color = ColorPalette.PrimaryColor400
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Text(
        text = "Batas Submisi Lembar Kerja",
        style = StyledText.MobileBaseSemibold,
        color = ColorPalette.PrimaryColor700
      )
      Text(
        text = "Selasa, 2 April 2024 13.55 WIB",
        style = StyledText.MobileBaseRegular,
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Text(
        text = "Tautan Lembar Kerja Peserta",
        style = StyledText.MobileBaseSemibold,
        color = ColorPalette.PrimaryColor700
      )
      CustomOutlinedTextField(
        value = "",
        onValueChange = {},
        label = "Masukkan tautan lembar kerja",
        placeholder = "Masukkan tautan lembar kerja",
      )
    }
    HorizontalDivider()
    Row(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
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
      @Suppress("DEPRECATION")
      OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
          contentColor = ColorPalette.PrimaryColor700,
        ),
        border = outlinedButtonBorder.copy(
          brush = SolidColor(ColorPalette.PrimaryColor700),
          width = 1.dp
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