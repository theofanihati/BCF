package com.example.slicingbcf.implementation.peserta.worksheet_peserta

<<<<<<< HEAD
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
=======
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
>>>>>>> source-repo/main
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.shared.PrimaryButton
import com.example.slicingbcf.ui.shared.message.SecondaryButton
import com.example.slicingbcf.ui.shared.textfield.CustomOutlinedTextField

// TODO: RAPIHIN LAYOUT + TAMBAHIN ITEMS ITEMS LAINNYA YANG ADA DI COLUMN JUDUL DLL
@Composable
<<<<<<< HEAD
@Preview(showSystemUi = true)
fun DetailWorksheetPeserta() {
  Column {
=======
fun DetailWorksheetPesertaScreen(
  modifier : Modifier = Modifier,
  id : String
) {
  Column(
    modifier = modifier.padding(
      horizontal = 16.dp,
    ),
    verticalArrangement = Arrangement.spacedBy(36.dp),
  ) {
>>>>>>> source-repo/main
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
<<<<<<< HEAD
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
=======
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
        rounded = 40,
        modifier = Modifier.fillMaxWidth(),

        )
    }
    HorizontalDivider()
    Row(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {

      PrimaryButton(
        onClick = {},
        text = "Simpan",
        color = ColorPalette.PrimaryColor700,
        style = StyledText.MobileSmallMedium,
      )
      SecondaryButton(
        onClick = {},
        text = "Batal",
        color = ColorPalette.PrimaryColor700,
        borderColor = ColorPalette.PrimaryColor700,
      )

>>>>>>> source-repo/main
    }
  }
}