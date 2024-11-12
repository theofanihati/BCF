package com.example.slicingbcf.implementation.peserta.pengumuman_peserta

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.R
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText

@Composable
@Preview(showSystemUi = true)
fun DetailPengumumanPeserta() {
  Column {
    Text(
      text = "MISI 2: Share Momen Onboarding Nasional LEAD 8",

      // Mobile/large/Medium
      style = StyledText.MobileLargeMedium,
    )
    Column {
      Image(
        painter = painterResource(id = R.drawable.ex_pengumuman),
        contentDescription = "Pengumuman",
        modifier = Modifier
          .size(
            width = 381.dp,
            height = 147.dp
          )
      )
      Row {
        Icon(
          Icons.Outlined.Favorite,
          contentDescription = "" // Add a valid content description
        )
        Text(
          text = "55",

          // Mobile/small/Regular
          style = StyledText.MobileSmallRegular,
        )
        Text(
          text = "31 Maret 2023, 10.00 WIB",

          // Mobile/small/Regular
          style = StyledText.MobileSmallRegular,
        )

      }
    }
    Text(
      text = "31 Maret 2023, 10.00 WIB",

      // Mobile/small/Regular
      style = StyledText.MobileSmallRegular,
    )
    Column {
      Text(
        text = "Link Submit MISI:",
        style = StyledText.MobileBaseMedium
      )
      Text(
        text = "https://bit.ly/MISICLP8",
        style = StyledText.MobileBaseRegular,
        color = ColorPalette.PrimaryColor400
      )
    }
    Text(
      text = "Batas waktu submit MISI 2 adalah Minggu, 7 April 2023 pukul 23.30 WIB. Setelah itu link formulir submit akan ditutup dan dibuka kembali di misi selanjutnya.",
      style = StyledText.MobileBaseRegular
    )

  }
}