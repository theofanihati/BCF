package com.example.slicingbcf.implementation.peserta.pengumuman_peserta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun PengumumanPeserta() {
  val currentTab by remember { mutableIntStateOf(0) }
  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    TopSection(currentTab)
    BottomSection()
  }

}

@Composable
fun BottomSection() {
  LazyColumn {
    items(pengumumans.size) { index ->
      PengumumanItem(
        pengumuman = pengumumans[index]
      )
    }
  }
}

@Composable
fun PengumumanItem(
  pengumuman : Pengumuman
) {
  Row {
    Box(
      Modifier
        .size(InputChipDefaults.AvatarSize)
        .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
    ) {
      Icon(
        Icons.Outlined.Notifications,
        contentDescription = ""
      )
      Badge {
        val badgeNumber = ""
        Text(
          badgeNumber,
          modifier = Modifier.semantics {
            contentDescription = "$badgeNumber new notifications"
          }
        )
      }
    }
    Column {
      Text(
        text = pengumuman.title,
        color = ColorPalette.Black,
        style = StyledText.MobileSmallRegular,
      )
      Text(
        text = pengumuman.date.toString(),
        // Mobile/xs/Regular
        style = StyledText.MobileXsRegular,
        color = ColorPalette.Monochrome400
      )

    }
  }
}


data class Pengumuman(
  val title : String,
  val date : Date,
  val content : String
)

val pengumumans = listOf(
  Pengumuman(
    title = "Pengumuman 1",
    date = Date(),
    content = "Content 1"
  ),
  Pengumuman(
    title = "Pengumuman 2",
    date = Date(),
    content = "Content 2"
  ),
  Pengumuman(
    title = "Pengumuman 3",
    date = Date(),
    content = "Content 3"
  ),
  Pengumuman(
    title = "Pengumuman 4",
    date = Date(),
    content = "Content 4"
  ),
  Pengumuman(
    title = "Pengumuman 5",
    date = Date(),
    content = "Content 5"
  ),
)

@Composable
fun TopSection(
  currentTab : Int
) {
  Row(
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(
      text = "Pengumuman",

      // Mobile/large/Medium
      style = StyledText.MobileLargeMedium,
    )
    Text(
      text = "Tandai telah dibaca",

      // Mobile/small/Medium
      style = StyledText.MobileSmallMedium,
      color = ColorPalette.PrimaryColor700
    )
  }
  Tabs(currentTab)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tabs(
  currentTab : Int
) {
  PrimaryTabRow(selectedTabIndex = currentTab) {
    Tab(
      selected = true,
      onClick = { },
      text = { Text(text = "Semua", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
    Tab(
      selected = false,
      onClick = { },
      text = { Text(text = "Berita", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
    Tab(
      selected = false,
      onClick = { },
      text = { Text(text = "LEAD", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
    Tab(
      selected = false,
      onClick = { },
      text = { Text(text = "BCF", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
  }

}