package com.example.slicingbcf.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.slicingbcf.constant.ColorPalette

private val DarkColorScheme = darkColorScheme(
  background = ColorPalette.OnPrimary
)

private val LightColorScheme = lightColorScheme(

  background = ColorPalette.OnPrimary,
  onBackground = ColorPalette.Black,
  surface = ColorPalette.OnPrimary,
  onSurface = ColorPalette.Black,
)

@Composable
fun SlicingBcfTheme(
  darkTheme : Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
//  dynamicColor : Boolean = true,
  // ! false karena harus sesuai dengan figma
  dynamicColor : Boolean = false,
  content : @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme                                                      -> DarkColorScheme
    else                                                           -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}