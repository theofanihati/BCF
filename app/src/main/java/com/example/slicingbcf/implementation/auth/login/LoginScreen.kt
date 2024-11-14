@file:Suppress("t")

package com.example.slicingbcf.implementation.auth.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.navigation.Screen
import com.example.slicingbcf.ui.navigation.navigateAndClearStack
import com.example.slicingbcf.ui.navigation.navigateSingleTop
import com.example.slicingbcf.ui.shared.CenteredAuthImage
import com.example.slicingbcf.ui.shared.CenteredLogo
import com.example.slicingbcf.ui.shared.CustomOutlinedTextField
import com.example.slicingbcf.ui.shared.message.ErrorMessage
import com.example.slicingbcf.ui.shared.message.SuccessMessage

@Composable
fun LoginScreen(
  modifier : Modifier = Modifier,
  navController : NavHostController,
  viewModel : LoginViewModel = hiltViewModel()
) {
  val state by viewModel.uiState.collectAsState()

  val isPasswordVisible = remember { mutableStateOf(false) }
  fun onNavigateToForgotPassword() {
    navController.navigateSingleTop(Screen.Auth.ForgotPassword.route)
  }

  LaunchedEffect(state.isSuccess) {

    if (state.isSuccess) {
      navController.navigateAndClearStack(Screen.Home.route)
      viewModel.onEvent(LoginEvent.ClearState)
    }
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
      onNavigateToForgotPassword = { onNavigateToForgotPassword() },
      email = state.email,
      password = state.password,
      onEmailChange = { viewModel.onEvent(LoginEvent.EmailChanged(it)) },
      onPasswordChange = { viewModel.onEvent(LoginEvent.PasswordChanged(it)) },
      onLoginClick = { viewModel.onEvent(LoginEvent.Submit) },
      emailError = state.emailError,
      passwordError = state.passwordError,
      isPasswordVisible = isPasswordVisible
    )
    AnimatedVisibility(state.isSuccess) {
      SuccessMessage(
        message = "Login Success."
      )
    }

    AnimatedVisibility(state.error != null) {
      ErrorMessage(
        message = state.error ?: ""
      )
    }
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
  onNavigateToForgotPassword : () -> Unit,
  email : String,
  password : String,
  onEmailChange : (String) -> Unit,
  onPasswordChange : (String) -> Unit,
  onLoginClick : () -> Unit,
  emailError : String?,
  passwordError : String?,
  isPasswordVisible : MutableState<Boolean>

) {

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp)
//    TODO: Add text field
  ) {
    CustomOutlinedTextField(
      value = email,
      onValueChange = { onEmailChange(it) },
      label = "Email Peserta",
      placeholder = "contoh: @gmail.com",
      leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email") },
      keyboardType = KeyboardType.Email,
      error = emailError,
      modifier = Modifier.fillMaxWidth()
    )
    CustomOutlinedTextField(
      value = password,
      onValueChange = { onPasswordChange(it) },
      label = "Kata Sandi",
      placeholder = "Masukkan kata sandi anda",
      isPassword = true,
      keyboardType = KeyboardType.Password,
      error = passwordError,
      modifier = Modifier.fillMaxWidth(),
      isPasswordVisible = isPasswordVisible
    )
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
        onLoginClick()
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
