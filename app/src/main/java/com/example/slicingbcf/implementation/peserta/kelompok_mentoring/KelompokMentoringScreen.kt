package com.example.slicingbcf.implementation.peserta.kelompok_mentoring

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.R
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.data.local.KelompokMentoring
import com.example.slicingbcf.data.local.headerKelompokMentorings
import com.example.slicingbcf.data.local.kelompoksMentoring

@Preview(showSystemUi = true)
@Composable
fun KelompokMentoringScreen(
  modifier : Modifier = Modifier

) {
  Column(
    modifier = modifier.padding(
      horizontal = 16.dp
    ),
    verticalArrangement = Arrangement.spacedBy(40.dp),

    ) {
    TopSection()
    BottomSection()
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection() {
  var currentTabIndex by remember { mutableIntStateOf(0) }
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
      onClick = {
        if (currentTabIndex != 0) currentTabIndex = 0

      },
      text = { Text(text = "Cluster", maxLines = 2, overflow = TextOverflow.Ellipsis) }
    )
    Tab(
      selected = false,
      onClick = {
        if (currentTabIndex != 1) currentTabIndex = 1

      },
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
  ScrollableTable(kelompoksMentoring)

}

@Composable
fun ScrollableTable(
  kelompoksMentoring : List<KelompokMentoring>
) {
  val scrollState = rememberScrollState()

  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Box(
      modifier = Modifier
        .padding()
        .fillMaxWidth()
        .background(ColorPalette.F5F9FE)
        .border(

          width = 1.dp,
          color = ColorPalette.Monochrome300,
          shape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp
          )
        ),
    ) {
      Text(
        text = "Kelompok Mentoring",
        style = StyledText.MobileXsBold,
        color = ColorPalette.Monochrome900,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp)
      )
    }

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(scrollState)
    ) {
      Column {
        HeaderRow()
        kelompoksMentoring.forEachIndexed { i, kelompokMentoring ->
          KelompokMentoringRow(kelompokMentoring, i)
        }
      }
    }
  }

}

@Composable
fun HeaderRow(
) {
  Row(
    modifier = Modifier
      .background(ColorPalette.F5F9FE)
      .border(
        width = 1.dp,
        color = ColorPalette.Monochrome300,
      )
  ) {
    headerKelompokMentorings.forEach { header ->
      TableCell(
        text = header.name,
        isHeader = true,
        weight = header.weight,
      )
    }
  }
}

@Composable
fun TableCell(
  text : String,
  isHeader : Boolean = false,
  weight : Float,
  color : Color = ColorPalette.Monochrome900
) {
  Text(
    text = text,
    style = if (isHeader) StyledText.MobileXsBold else StyledText.MobileXsRegular,
    color = color,
    modifier = Modifier
      .width(120.dp * weight)
      .padding(8.dp)
  )
}

@Composable
fun KelompokMentoringRow(kelompokMentoring : KelompokMentoring, i : Int) {
  val backgroundColor = if (i % 2 == 0) {
    MaterialTheme.colorScheme.surface
  } else {
    MaterialTheme.colorScheme.surfaceVariant
  }

  // TODO
  Row(
    modifier = Modifier
      .background(backgroundColor)
      .border(
        width = 1.dp,
        color = ColorPalette.Monochrome300,
      )
  ) {
    headerKelompokMentorings.forEach { header ->
      TableCell(
        text = when (header.name) {
          "No"             -> (i + 1).toString()
          "Nama Lembaga"   -> kelompokMentoring.namaLembaga
          "Fokus Isu"      -> kelompokMentoring.fokusIsu
          "Jumlah Peserta" -> kelompokMentoring.jumlahPeserta.toString()
          "Jumlah Mentor"  -> kelompokMentoring.jumlahMentor.toString()
          "Jumlah Sesi"    -> kelompokMentoring.jumlahSesi.toString()
          else             -> ""
        },
        isHeader = false,
        weight = header.weight,
        color = ColorPalette.Monochrome900
      )
    }
  }


}



