@file:Suppress("t")

package com.example.slicingbcf.ui.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.StyledText


@Composable
fun CustomOutlinedTextField(
  value : String,
  onValueChange : (String) -> Unit,
  label : String,
  placeholder : String,
  modifier : Modifier = Modifier,
  isPassword : Boolean = false,
  isPasswordVisible : MutableState<Boolean>? = null,
  keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
) {
  OutlinedTextField(
    singleLine = true,
    value = value,
    onValueChange = onValueChange,
    label = {
      Text(
        text = label,
        style = StyledText.Mobile3xsMedium
      )
    },
    placeholder = {
      Text(
        text = placeholder,
        style = StyledText.MobileSmallRegular
      )
    },
    textStyle = StyledText.MobileSmallRegular,
    shape = RoundedCornerShape(32.dp),
    modifier = modifier.fillMaxWidth(),
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
