package com.example.slicingbcf.ui.shared

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.R
import com.example.slicingbcf.constant.ColorPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun MainScaffold(
  content : @Composable (PaddingValues) -> Unit = { }
) {
  Scaffold(
    topBar = {
      TopAppBar(

        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = ColorPalette.Monochrome100,
        ),
        title = {
          Image(
            painter = painterResource(id = R.drawable.logo_lead),
            contentDescription = stringResource(id = R.string.logo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
              .size(
                width = 56.dp,
                height = 35.dp
              )
          )
        },
        actions = {
          IconButton(
            onClick = {
              Log.d("MainScaffold", "Menu clicked")
            }
          ) {
            Icon(
              imageVector = Icons.Default.Menu,
              contentDescription = "Menu"
            )
          }
        },

        )
    },

    ) { innerPadding ->
    content(innerPadding)
  }
}

@Composable
fun TopBar() {
  Row(
    modifier = Modifier
      .padding(
        horizontal = 16.dp,
      ),
    horizontalArrangement = Arrangement.SpaceBetween
  ) { }
}

@Composable
fun BottomBar() {
}