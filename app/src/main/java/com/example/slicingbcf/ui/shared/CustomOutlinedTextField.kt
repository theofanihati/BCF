package com.example.slicingbcf.ui.shared

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.ui.shared.message.ErrorMessageTextField

@Composable
fun CustomOutlinedTextField(
  modifier : Modifier = Modifier,
  value : String,
  onValueChange : (String) -> Unit,
  label : String,
  placeholder : String,
  isPassword : Boolean = false,
  isPasswordVisible : MutableState<Boolean>? = null,
  leadingIcon : @Composable (() -> Unit) = {
    Icon(imageVector = Icons.Filled.Person, contentDescription = label)
  },
  keyboardType : KeyboardType = KeyboardType.Text,
  error : String? = null,
  rounded : Int = 16,
  multiLine : Boolean = false
) {
  Column {
    OutlinedTextField(
      value = value,
      onValueChange = onValueChange,
      modifier = modifier,
      singleLine = ! multiLine,
      maxLines = if (multiLine) 5 else 1,
      shape = RoundedCornerShape(rounded),
      leadingIcon = leadingIcon,
      trailingIcon = {
        if (isPasswordVisible != null) {
          PasswordVisibilityIcon(
            isPasswordVisible
          )
        }
      },
      visualTransformation = getVisualTransformation(isPassword, isPasswordVisible),
      keyboardOptions = getKeyboardOptions(isPassword, keyboardType),
      label = { TextLabel(label, error) },
      placeholder = { PlaceholderText(placeholder) },
      textStyle = StyledText.MobileSmallRegular,
      isError = error != null,
      colors = getTextFieldColors()
    )

    AnimatedVisibility(visible = error != null) {
      error?.let {
        ErrorMessageTextField(it)
      }
    }
  }
}

@Composable
private fun PasswordVisibilityIcon(isPasswordVisible : MutableState<Boolean>) {
  IconButton(onClick = { isPasswordVisible.value = ! isPasswordVisible.value }) {
    Icon(
      imageVector = if (isPasswordVisible.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
      contentDescription = if (isPasswordVisible.value) "Hide Password" else "Show Password"
    )
  }
}

@Composable
private fun getVisualTransformation(
  isPassword : Boolean,
  isPasswordVisible : MutableState<Boolean>?
) : VisualTransformation {
  return if (isPassword && isPasswordVisible?.value == false) {
    PasswordVisualTransformation()
  } else {
    VisualTransformation.None
  }
}

@Composable
private fun getKeyboardOptions(
  isPassword : Boolean,
  keyboardType : KeyboardType
) : KeyboardOptions {
  return KeyboardOptions.Default.copy(
    keyboardType = if (isPassword) KeyboardType.Password else keyboardType
  )
}

@Composable
private fun TextLabel(label : String, error : String?) {
  Text(
    text = label,
    style = StyledText.MobileSmallRegular,
    color = if (error != null) ColorPalette.Error else ColorPalette.Monochrome300
  )
}

@Composable
private fun PlaceholderText(placeholder : String) {
  Text(
    text = placeholder,
    style = StyledText.MobileSmallRegular,
    color = ColorPalette.Monochrome300
  )
}

@Composable
private fun getTextFieldColors() : TextFieldColors {
  return OutlinedTextFieldDefaults.colors(
    unfocusedBorderColor = ColorPalette.Monochrome300,
    focusedBorderColor = ColorPalette.Monochrome300,
    errorBorderColor = ColorPalette.Error,
    errorLabelColor = ColorPalette.Error,
    errorLeadingIconColor = ColorPalette.Error,
    errorTrailingIconColor = ColorPalette.Error
  )
}
