package com.example.slicingbcf.implementation.auth.login

data class LoginState(
  val email : String = "",
  val emailError : String = "",
  val password : String = "",
  val passwordError : String = "",
  val isLoading : Boolean = false,
  val error : String? = null,
  val message : String? = null
)