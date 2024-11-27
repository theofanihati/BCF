package com.example.slicingbcf.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.slicingbcf.implementation.auth.forgot_password.ForgotPasswordScreen
import com.example.slicingbcf.implementation.auth.login.LoginScreen
import com.example.slicingbcf.implementation.auth.registrasi.RegistrasiScreen

fun NavGraphBuilder.authNavGraph(
  modifier : Modifier,
  navController : NavHostController
) {
  navigation(startDestination = Screen.Auth.Registrasi.route, route = "auth") {
    composable(Screen.Auth.Login.route) {
      LoginScreen(
        modifier = modifier,
        navController = navController
      )
    }
    composable(Screen.Auth.ForgotPassword.route) {
      ForgotPasswordScreen(
        modifier = modifier,
        navController = navController
      )
    }

    composable(Screen.Auth.Registrasi.route) {
      RegistrasiScreen(
        modifier = modifier,
      )
    }


  }
}
