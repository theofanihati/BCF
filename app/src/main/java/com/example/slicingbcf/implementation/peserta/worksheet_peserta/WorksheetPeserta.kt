package com.example.slicingbcf.implementation.peserta.worksheet_peserta

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.data.local.WorksheetPeserta
import com.example.slicingbcf.data.local.worksheetsPeserta

@Composable
@Preview(showSystemUi = true)
fun WorksheetPesertaScreen(
  modifier : Modifier = Modifier
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(32.dp),
    modifier = modifier.padding(
      horizontal = 16.dp
    )
  ) {
    Text(
      text = "Lembar Kerja",
      style = StyledText.MobileMediumMedium,
      color = ColorPalette.Black,
      textAlign = TextAlign.Center,
      modifier = Modifier.fillMaxWidth()
    )
    LazyColumn(
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
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
      .padding(
        horizontal = 4.dp,
        vertical = 8.dp
      ),
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    IconButton(
      onClick = { /*TODO*/ }
    ) {
      Icon(
        Icons.Outlined.Folder,
        contentDescription = ""
      )
    }
    Column(
      modifier = Modifier.weight(1f)

    ) {
      Text(
        text = worksheet.title,
        style = StyledText.MobileSmallSemibold,
        color = ColorPalette.OnSurface
      )
      Text(
        text = worksheet.description,
        style = StyledText.MobileSmallRegular,
        color = ColorPalette.OnSurface
      )
    }
    IconButton(
      onClick = { /*todo*/ }
    ) {
      Icon(
        Icons.AutoMirrored.Default.NavigateNext,
        contentDescription = ""
      )
    }
  }
}