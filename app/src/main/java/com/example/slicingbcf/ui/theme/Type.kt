package com.example.slicingbcf.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.slicingbcf.R

val Poppins = FontFamily(
  Font(R.font.poppins_regular, FontWeight.Normal),
  Font(R.font.poppins_medium, FontWeight.W500),
  Font(R.font.poppins_semibold, FontWeight.W600),
  Font(R.font.poppins_bold, FontWeight.W700)
)


val Typography = Typography(
  titleLarge = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W700,
    fontSize = 28.sp,
    lineHeight = 33.6.sp,
  ),
  bodyLarge = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W600,
    fontSize = 16.sp,
    lineHeight = 22.4.sp,
  ),
  bodyMedium = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W400,
    fontSize = 12.sp,
    lineHeight = 16.8.sp,
  ),
  labelLarge = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp,
    lineHeight = 19.6.sp,
  ),
  labelMedium = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W600,
    fontSize = 20.sp,
    lineHeight = 28.sp,
  ),
  labelSmall = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W400,
    fontSize = 10.sp,
    lineHeight = 14.sp,
  ),
  displaySmall = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W700,
    fontSize = 12.sp,
    lineHeight = 16.8.sp,
  ),
  displayMedium = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W500,
    fontSize = 18.sp,
    lineHeight = 25.2.sp,
  ),
  displayLarge = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.W400,
    fontSize = 11.sp,
    lineHeight = 15.4.sp,
  )
)
