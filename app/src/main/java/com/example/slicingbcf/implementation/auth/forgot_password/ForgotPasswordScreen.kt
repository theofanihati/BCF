@file:Suppress("t")

package com.example.slicingbcf.implementation.auth.forgot_password

import androidx.compose.foundation.layout.*
<<<<<<< HEAD
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
=======
import androidx.compose.material3.*
import androidx.compose.runtime.*
>>>>>>> source-repo/main
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
<<<<<<< HEAD
=======
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
>>>>>>> source-repo/main
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.shared.CenteredAuthImage
import com.example.slicingbcf.ui.shared.CenteredLogo
<<<<<<< HEAD
import com.example.slicingbcf.ui.shared.CustomOutlinedTextField
=======
import com.example.slicingbcf.ui.shared.PrimaryButton
import com.example.slicingbcf.ui.shared.message.ErrorMessage
import com.example.slicingbcf.ui.shared.message.SuccessMessage
import com.example.slicingbcf.ui.shared.textfield.CustomOutlinedTextField
>>>>>>> source-repo/main

@Composable
@Preview(showSystemUi = true)
fun ForgotPasswordScreen() {
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
      text = "Atur Ulang Kata Sandi",
      style = StyledText.MobileLargeSemibold
    )
    Text(
      text = "Masukkan email akun yang sudah didaftarkan",
      style = StyledText.MobileSmallRegular
    )

  }
}

@Composable
fun BottomSection(
  isPasswordVisible : MutableState<Boolean>
) {
  val email = remember { mutableStateOf("") }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .fillMaxWidth()
<<<<<<< HEAD
      .padding(horizontal = 16.dp)
  ) {
    CustomOutlinedTextField(
      value = email.value,
      onValueChange = { email.value = it },
      label = "Email Peserta",
      placeholder = "contoh: @gmail.com"
    )
=======
      .padding(horizontal = 16.dp),

    ) {

    CustomOutlinedTextField(
      value = email,
      onValueChange = { onChange(it) },
      label = "Email Peserta",
      placeholder = "contoh: @gmail.com",
      keyboardType = KeyboardType.Email,
      error = emailError,
      modifier = Modifier.fillMaxWidth(),
      rounded = 40
    )

  }
  Column(
    modifier = Modifier.padding(
      horizontal = 16.dp
    ),
    verticalArrangement = Arrangement.spacedBy(32.dp),
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(),
      contentAlignment = Alignment.Center,
    ) {

      PrimaryButton(
        text = "Kirim",
        onClick = onSubmit,
        modifier = Modifier.fillMaxWidth(),
        style = StyledText.MobileSmallMedium,


        )
    }
    GotoLogin(navigateToLogin)
>>>>>>> source-repo/main
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
  Box(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center,

    ) {
    Text(
      text = buildAnnotatedString {
        append("Ingat kata sandi? ")
        withStyle(
          style = SpanStyle(
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Medium,

            )
        ) {
          append("Masuk")
        }

      },
<<<<<<< HEAD
      style = StyledText.MobileSmallRegular,
=======
      modifier = Modifier.clickable { navigateToLogin() },
      style = StyledText.MobileSmallRegular,
      color = ColorPalette.Black
>>>>>>> source-repo/main
    )
  }
}
