package com.example.slicingbcf.implementation.peserta.worksheet_peserta

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.data.local.WorksheetPeserta
import com.example.slicingbcf.data.local.worksheetsPeserta

// TODO: RAPIHIN LAYOUT
@Composable
@Preview(showSystemUi = true)
fun WorksheetPeserta() {
  Column() {
    Text(
      text = "Lembar Kerja",

      // Mobile/medium/Medium
      style = StyledText.MobileMediumMedium,
      color = ColorPalette.Black
    )
    LazyColumn() {
      items(worksheetsPeserta.size) { index ->
        WorksheetItem(
          worksheet = worksheetsPeserta[index]
        )
      }

    }
  }
}

@Composable
fun WorksheetItem(worksheet : WorksheetPeserta) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .border(
        width = 1.dp,
        color = ColorPalette.OnSurfaceVariant,
        shape = RoundedCornerShape(8.dp),
      )

  ) {
    Icon(
      Icons.Outlined.Folder,
      contentDescription = "" // Add a valid content description
    )
    Column {
      Text(
        text = worksheet.title,
        style = StyledText.MobileSmallMedium,
        color = ColorPalette.OnSurface
      )
      Text(
        text = worksheet.description,
        style = StyledText.MobileSmallRegular,
        color = ColorPalette.OnSurface
      )


    }
    Icon(
      Icons.AutoMirrored.Default.NavigateNext,
      contentDescription = "" // Add a valid content description
    )
  }
}