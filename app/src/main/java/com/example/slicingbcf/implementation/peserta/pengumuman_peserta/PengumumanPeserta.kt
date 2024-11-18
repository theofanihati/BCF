package com.example.slicingbcf.implementation.peserta.pengumuman_peserta

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
<<<<<<< HEAD
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
=======
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
>>>>>>> source-repo/main
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
<<<<<<< HEAD
fun PengumumanPeserta() {
  val currentTab by remember { mutableIntStateOf(0) }
=======
fun PengumumanPesertaScreen(
  modifier : Modifier = Modifier
) {
  var currentTab by remember { mutableIntStateOf(0) }
>>>>>>> source-repo/main
  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    TopSection(currentTab) { selectedTab ->
      currentTab = selectedTab
    }
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
  currentTab : Int,
  onTabSelected : (Int) -> Unit
) {
  Row(
<<<<<<< HEAD
    horizontalArrangement = Arrangement.SpaceBetween
=======
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
>>>>>>> source-repo/main
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
  Tabs(currentTab, onTabSelected)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tabs(
  currentTab : Int,
  onTabSelected : (Int) -> Unit
) {
<<<<<<< HEAD
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
=======
  TabRow(
    selectedTabIndex = currentTab,
    indicator = { tabPositions ->
      SecondaryIndicator(
        Modifier.tabIndicatorOffset(tabPositions[currentTab]),
        height = 3.dp,
        color = ColorPalette.PrimaryColor700
      )
    }
  ) {
    TabWithBadge(
      selected = currentTab == 0,
      onClick = { onTabSelected(0) },
      text = "Semua",
      badgeNumber = "5"
    )
    TabWithBadge(
      selected = currentTab == 1,
      onClick = { onTabSelected(1) },
      text = "Berita",
      badgeNumber = "10"
    )
    TabWithBadge(
      selected = currentTab == 2,
      onClick = { onTabSelected(2) },
      text = "LEAD",
      badgeNumber = "10"
    )
    TabWithBadge(
      selected = currentTab == 3,
      onClick = { onTabSelected(3) },
      text = "BCF",
      badgeNumber = "10"
    )
  }

}

@Composable
fun TabWithBadge(
  selected : Boolean = false,
  onClick : () -> Unit = { },
  text : String,
  badgeNumber : String,
) {
  Tab(
    selected = selected,
    onClick = onClick,
    text = {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.clickable { onClick() }
      ) {
        Text(
          text = text,
          style = StyledText.MobileXsMedium,
          color = if (selected) ColorPalette.PrimaryColor700 else ColorPalette.Monochrome400
        )
        Badge(
          modifier = Modifier.size(20.dp),
          contentColor = ColorPalette.OnError,
        ) {
          Text(
            badgeNumber,
            textAlign = TextAlign.Center,
            style = StyledText.Mobile2xsRegular,
            color = ColorPalette.OnError
          )
        }
      }
    }
  )
}
>>>>>>> source-repo/main
