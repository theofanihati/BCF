package com.example.slicingbcf.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

fun NavController.navigateSingleTop(route : String) {
  this.navigate(route) {
    launchSingleTop = true
  }
}

fun NavController.navigateAndClearStack(route : String) {
  this.navigate(route) {
    popUpTo(graph.startDestinationId) {
      inclusive = true
    }
    launchSingleTop = true
  }
}

fun NavController.navigateWithClearUntil(route : String, clearUntilRoute : String) {
  this.navigate(route) {
    popUpTo(clearUntilRoute) {
      inclusive = true
    }
    launchSingleTop = true
  }
}

fun NavController.navigateWithAnimation(
  route : String,
  builder : NavOptionsBuilder.() -> Unit = {}
) {
  this.navigate(route) {
    launchSingleTop = true
    builder()
  }
}
