@file:Suppress("t")

package com.example.slicingbcf.implementation.auth.login

<<<<<<< HEAD
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
=======
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
>>>>>>> source-repo/main
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
<<<<<<< HEAD
import com.example.slicingbcf.ui.shared.CenteredAuthImage
import com.example.slicingbcf.ui.shared.CenteredLogo
import com.example.slicingbcf.ui.shared.CustomOutlinedTextField
=======
import com.example.slicingbcf.ui.animations.AnimatedMessage
import com.example.slicingbcf.ui.animations.MessageType
import com.example.slicingbcf.ui.navigation.Screen
import com.example.slicingbcf.ui.navigation.navigateAndClearStack
import com.example.slicingbcf.ui.navigation.navigateSingleTop
import com.example.slicingbcf.ui.shared.CenteredAuthImage
import com.example.slicingbcf.ui.shared.CenteredLogo
import com.example.slicingbcf.ui.shared.textfield.CustomOutlinedTextField
import kotlinx.coroutines.delay

//@Preview(showSystemUi = true)
//@Composable
//fun LoginScreenPreview() {
//  LoginScreen(
//    navController = rememberNavController(),
//    )
//}
>>>>>>> source-repo/main

@Composable
@Preview(showSystemUi = true)
fun LoginScreen() {
  val isPasswordVisible = remember { mutableStateOf(false) }
<<<<<<< HEAD

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
=======
  fun onNavigateToForgotPassword() {
    navController.navigateSingleTop(Screen.Auth.ForgotPassword.route)
  }

  LaunchedEffect(state.isSuccess) {
    if (state.isSuccess) {
      delay(1500)
      navController.navigateAndClearStack(Screen.Home.route)
      viewModel.onEvent(LoginEvent.ClearState)
    }
  }

  Box(
    modifier = modifier
      .background(ColorPalette.OnPrimary)
      .statusBarsPadding()
      .padding(horizontal = 16.dp)
  ) {

    Column(
      verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
      modifier = Modifier.fillMaxSize()
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
    }

    AnimatedMessage(
      isVisible = state.isSuccess,
      message = state.message ?: "Login Success.",
      messageType = MessageType.Success,
      modifier = Modifier
        .padding(top = 16.dp)
        .align(Alignment.TopCenter)
    )

    AnimatedMessage(
      isVisible = state.error != null,
      message = state.error ?: "",
      messageType = MessageType.Error,
      modifier = Modifier
        .padding(top = 16.dp)
        .align(Alignment.TopCenter)
    )

>>>>>>> source-repo/main
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
<<<<<<< HEAD
=======

//    TODO: Add text field
>>>>>>> source-repo/main
  ) {
    CustomOutlinedTextField(
      value = email.value,
      onValueChange = { email.value = it },
      label = "Email Peserta",
<<<<<<< HEAD
      placeholder = "contoh: @gmail.com"
=======
      placeholder = "contoh: @gmail.com",
      keyboardType = KeyboardType.Email,
      error = emailError,
      modifier = Modifier.fillMaxWidth(),
      rounded = 40
>>>>>>> source-repo/main
    )
    CustomOutlinedTextField(
      value = password.value,
      onValueChange = { password.value = it },
      label = "Kata Sandi",
      placeholder = "Masukkan kata sandi anda",
      isPassword = true,
<<<<<<< HEAD
      isPasswordVisible = isPasswordVisible,
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
=======
      keyboardType = KeyboardType.Password,
      error = passwordError,
      modifier = Modifier.fillMaxWidth(),
      isPasswordVisible = isPasswordVisible,
      rounded = 40
>>>>>>> source-repo/main
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
<<<<<<< HEAD
=======


@Composable
fun GotoForgotPassword(navigateToForgotPassword : () -> Unit) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.End,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Text(
      text = "Lupa kata sandi",
      style = StyledText.MobileSmallRegular,
      modifier = Modifier.clickable { navigateToForgotPassword() },
      textDecoration = TextDecoration.Underline

    )


  }
}
>>>>>>> source-repo/main
