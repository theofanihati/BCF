package com.example.slicingbcf.ui.scaffold

import com.example.slicingbcf.ui.navigation.Screen

data class ScaffoldConfig(
  val showMainNav : Boolean = true,
  val showBackNav : Boolean = false,
)

fun scaffoldConfig(currentRoute : String?)
  : ScaffoldConfig {
  return when (currentRoute) {
    Screen.Auth.Login.route          -> ScaffoldConfig(
      showMainNav = false,
    )

    Screen.Auth.ForgotPassword.route -> ScaffoldConfig(
      showMainNav = false,
    )

    "pengumuman-peserta/{id}"        -> ScaffoldConfig(
      showMainNav = false,
      showBackNav = true,
    )

    "worksheet-peserta/{id} "        -> ScaffoldConfig(
      showMainNav = false,
      showBackNav = true,
    )

    else                             -> ScaffoldConfig()

  }
}