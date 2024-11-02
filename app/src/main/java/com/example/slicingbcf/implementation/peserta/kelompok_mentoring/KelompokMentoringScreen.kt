package com.example.slicingbcf.implementation.peserta.kelompok_mentoring

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.R
import com.example.slicingbcf.constant.StyledText

@Preview(showSystemUi = true)
@Composable
fun KelompokMentoringScreen(

) {
  Column(
    verticalArrangement = Arrangement.spacedBy(40.dp),
    modifier = Modifier.padding(
      horizontal = 16.dp
    )
  ) {
    TopSection()
    BottomSection()
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection() {
  val currentTabIndex by remember { mutableIntStateOf(0) }
  Column(
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
          append("Halo")
        }
        append(", Peserta")
      },
      style = StyledText.MobileMediumRegular
    )
    Text(
      text = "Berikut Kelompok Mentoring dan Mentor yang akan menjadi pendampingmu selama perjalanan LEAD Indonesia!",
      style = StyledText.MobileSmallRegular
    )
  }
  PrimaryTabRow(selectedTabIndex = currentTabIndex) {
    Tab(
      selected = true,
      onClick = { },
      text = { Text(text = "Cluster", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
    Tab(
      selected = false,
      onClick = { },
      text = { Text(text = "Desain Program", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
  }
  Row(
    horizontalArrangement = Arrangement.spacedBy(20.dp)
  ) {
    Image(
      modifier = Modifier.size(100.dp),
      painter = painterResource(id = R.drawable.avatar),
      contentDescription = "Person",
    )
    Column(
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Text(
        text = "Dody Supriyadi",
        style = StyledText.MobileMediumMedium
      )
      Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        Text(
          text = "Mentor Cluster • Kesehatan",

          // Mobile/small/Regular
          style = StyledText.MobileSmallRegular
        )
        Text(
          text = "Tuberculosis (TBC) • Stunting • HIV/AIDS",
          style = StyledText.Mobile2xsRegular
        )
      }

    }
  }
}

// TODO: Implement BottomSection isinya table kelompok mentoring
@Composable
fun BottomSection() {
}