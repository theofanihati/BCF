@file:Suppress("t")

package com.example.slicingbcf.implementation.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.navigation.Screen
import com.example.slicingbcf.ui.navigation.navigateSingleTop
import com.example.slicingbcf.ui.shared.CenteredAuthImage
import com.example.slicingbcf.ui.shared.CenteredLogo

@Composable
fun LoginScreen(
  modifier : Modifier = Modifier,
  navController : NavHostController
) {
  val isPasswordVisible = remember { mutableStateOf(false) }

  fun onNavigateToForgotPassword() {
    navController.navigateSingleTop(Screen.Auth.ForgotPassword.route)
  }

  Column(
    verticalArrangement = Arrangement.spacedBy(
      32.dp,
      Alignment.Top
    ),
    modifier = modifier
      .statusBarsPadding()
      .padding(
        horizontal = 16.dp
      )
  ) {
    TopSection()
    CenteredAuthImage()
    BottomSection(
      isPasswordVisible = isPasswordVisible,
      onNavigateToForgotPassword = { onNavigateToForgotPassword() }
    )
  }
}

@Composable
fun TopSection() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    CenteredLogo(
      modifier = Modifier.size(
        width = 72.dp,
        height = 45.dp
      )
    )
    Text(
      text = buildAnnotatedString {
        append("Selamat datang di \n")
        withStyle(
          style = SpanStyle(color = ColorPalette.PrimaryColor700)
        ) {
          append("LEAD Indonesia!")
        }
      },
      style = StyledText.Mobile2xlBold,
      textAlign = TextAlign.Center
    )
    Text(
      text = "Silakan Masuk dengan Akun yang Sudah Didaftarkan",
      style = StyledText.MobileSmallRegular,
    )
  }
}

@Composable
fun BottomSection(
  isPasswordVisible : MutableState<Boolean>,
  onNavigateToForgotPassword : () -> Unit
) {
  val email = remember { mutableStateOf("") }
  val password = remember { mutableStateOf("") }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp)
//    TODO: Add text field
  ) {
//    CustomOutlinedTextField(
//      value = email.value,
//      onValueChange = { email.value = it },
//      label = "Email Peserta",
//      placeholder = "contoh: @gmail.com"
//    )
//    CustomOutlinedTextField(
//      value = password.value,
//      onValueChange = { password.value = it },
//      label = "Kata Sandi",
//      placeholder = "Masukkan kata sandi anda",
//      isPassword = true,
//      isPasswordVisible = isPasswordVisible,
//      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
//    )
    GotoForgotPassword(navigateToForgotPassword = onNavigateToForgotPassword)

  }
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        horizontal = 16.dp
      ),
    contentAlignment = Alignment.Center,
  ) {
    Button(
      colors = ButtonDefaults.buttonColors(
        containerColor = ColorPalette.PrimaryColor700,
      ),
      onClick = {
      },
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Text(
        text = "Masuk",
        style = StyledText.MobileSmallMedium,
      )
    }
  }
}


@Composable
fun GotoForgotPassword(navigateToForgotPassword : () -> Unit) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.End,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Text(
      text = "Lupa kata sandi? ",
      style = StyledText.MobileSmallRegular
    )

    Text(
      text = buildAnnotatedString {
        withStyle(
          style = SpanStyle(
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Medium
          )
        ) {
          append("Masuk")
        }
      },
      modifier = Modifier.clickable { navigateToForgotPassword() },
      style = StyledText.MobileSmallRegular
    )
  }
}
