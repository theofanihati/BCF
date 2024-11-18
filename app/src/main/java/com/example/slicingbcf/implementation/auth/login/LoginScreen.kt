@file:Suppress("t")

package com.example.slicingbcf.implementation.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.shared.CenteredAuthImage
import com.example.slicingbcf.ui.shared.CenteredLogo
import com.example.slicingbcf.ui.shared.CustomOutlinedTextField

@Composable
@Preview(showSystemUi = true)
fun LoginScreen() {
  val isPasswordVisible = remember { mutableStateOf(false) }

  Column(
    verticalArrangement = Arrangement.spacedBy(
      32.dp,
      Alignment.Top
    ),
    modifier = Modifier
      // TODO: DELETE LATER
      .padding(
        top = 20.dp,
      )
  ) {
    TopSection()
    CenteredAuthImage()
    BottomSection(isPasswordVisible = isPasswordVisible)
  }
}

@Composable
fun TopSection() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    CenteredLogo()
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
  isPasswordVisible : MutableState<Boolean>
) {
  val email = remember { mutableStateOf("") }
  val password = remember { mutableStateOf("") }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp)
  ) {
    CustomOutlinedTextField(
      value = email.value,
      onValueChange = { email.value = it },
      label = "Email Peserta",
      placeholder = "contoh: @gmail.com"
    )
    CustomOutlinedTextField(
      value = password.value,
      onValueChange = { password.value = it },
      label = "Kata Sandi",
      placeholder = "Masukkan kata sandi anda",
      isPassword = true,
      isPasswordVisible = isPasswordVisible,
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
    Box(
      modifier = Modifier.fillMaxWidth(),
      contentAlignment = Alignment.CenterEnd,

      ) {
      Text(
        text = "Lupa Kata Sandi?",
        style = StyledText.Mobile2xsRegular,
        textDecoration = TextDecoration.Underline,
      )
    }

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
      onClick = { /*TODO*/ },
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
