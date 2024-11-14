package com.example.slicingbcf.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText

@Preview(showSystemUi = true)
@Composable
fun CustomBackScaffold(
  content : @Composable (PaddingValues) -> Unit = { }
) {
  Scaffold(
    topBar = {
      TopBarBack()
    }
  ) { innerPadding ->
    content(innerPadding)
  }
}

@Composable
fun TopBarBack() {
  Row(
    modifier = Modifier
      .statusBarsPadding()
      .fillMaxWidth()
      .padding(
        12.dp
      ),
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconButton(onClick = {}) {
      Icon(
        Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "",
        tint = ColorPalette.PrimaryColor700
      )
    }
    Text(
      text = "Kembali",
      style = StyledText.MobileBaseRegular,
      color = ColorPalette.PrimaryColor700
    )


  }
}