@file:Suppress("t")

package com.example.slicingbcf.ui.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText


@Composable
fun CustomOutlinedTextField(
  value : String,
  onValueChange : (String) -> Unit,
  label : String,
  placeholder : String,
  modifier : Modifier = Modifier.fillMaxWidth(),
  isPassword : Boolean = false,
  isPasswordVisible : MutableState<Boolean>? = null,
  keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
) {
  OutlinedTextField(
    colors = OutlinedTextFieldDefaults.colors(
      unfocusedBorderColor = ColorPalette.Monochrome300,
      focusedBorderColor = ColorPalette.Monochrome300,
      errorBorderColor = ColorPalette.Monochrome300,
      disabledBorderColor = ColorPalette.Monochrome300,
      disabledTextColor = ColorPalette.Monochrome300,
      focusedTextColor = ColorPalette.Monochrome300,
      unfocusedTextColor = ColorPalette.Monochrome300,
      errorTextColor = ColorPalette.Monochrome300,

      ),
    singleLine = true,
    value = value,
    onValueChange = onValueChange,
    label = {
      Text(
        text = label,
        style = StyledText.MobileSmallRegular,
        color = ColorPalette.Monochrome300
      )
    },
    placeholder = {
      Text(
        text = placeholder,
        style = StyledText.MobileSmallRegular,
        color = ColorPalette.Monochrome300
      )
    },
    textStyle = StyledText.MobileSmallRegular,
    shape = RoundedCornerShape(32.dp),
    modifier = modifier,
    keyboardOptions = keyboardOptions,
    visualTransformation = if (isPassword && (isPasswordVisible?.value == false)) {
      PasswordVisualTransformation()
    } else {
      VisualTransformation.None
    },
    trailingIcon = if (isPassword && isPasswordVisible != null) {
      {
        IconButton(onClick = { isPasswordVisible.value = ! isPasswordVisible.value }) {
          Icon(
            imageVector = if (isPasswordVisible.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
            contentDescription = if (isPasswordVisible.value) "Hide Password" else "Show Password"
          )
        }
      }
    } else null
  )
}
