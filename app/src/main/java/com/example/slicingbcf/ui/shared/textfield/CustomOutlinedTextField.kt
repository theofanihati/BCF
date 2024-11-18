package com.example.slicingbcf.ui.shared.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
  leadingIcon : @Composable (() -> Unit)? = null,
  keyboardType : KeyboardType = KeyboardType.Text,
  error : String? = null,
  rounded : Int = 16,
  multiLine : Boolean = false,
  maxLines : Int = 1,
  isEnabled : Boolean = true,
  labelFocusedColor : Color = ColorPalette.OnSurfaceVariant,
  labelFocusedStyle : TextStyle = StyledText.MobileSmallRegular,
  labelDefaultColor : Color = ColorPalette.Monochrome300,
  trailingIcon : @Composable (() -> Unit)? = null,
  readOnly : Boolean = false,
) {
  val isFocused = remember { mutableStateOf(false) }


  Column {
    OutlinedTextField(
      value = value,
      onValueChange = onValueChange,
      modifier = modifier
        .onFocusChanged { isFocused.value = it.isFocused },
      singleLine = ! multiLine,
      maxLines = if (multiLine) maxLines else 1,
      shape = RoundedCornerShape(rounded),
      leadingIcon = leadingIcon,
      trailingIcon = {
        when {
          isPasswordVisible != null -> PasswordVisibilityIcon(isPasswordVisible)
          trailingIcon != null      -> trailingIcon()
        }
      },
      visualTransformation = getVisualTransformation(isPassword, isPasswordVisible),
      keyboardOptions = getKeyboardOptions(isPassword, keyboardType),
      label = {
        TextLabel(
          label = label,
          error = error,
          isFocused = isFocused.value,
          focusedColor = labelFocusedColor,
          styleFocused = labelFocusedStyle,
          defaultColor = labelDefaultColor,
          valueNotEmpty = value.isNotEmpty()

        )
      },
      placeholder = { PlaceholderText(placeholder) },
      textStyle = StyledText.MobileSmallRegular,
      isError = error != null,
      colors = getTextFieldColors(),
      enabled = isEnabled,
      readOnly = readOnly
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
private fun TextLabel(
  label : String,
  error : String?,
  isFocused : Boolean,
  focusedColor : Color = ColorPalette.OnSurfaceVariant,
  styleFocused : TextStyle = StyledText.MobileSmallRegular,
  defaultColor : Color = ColorPalette.Monochrome300,
  valueNotEmpty : Boolean
) {
  val color = when {
    error != null -> ColorPalette.Error
    isFocused     -> focusedColor
    else          -> defaultColor
  }
  val fontWeight = if (isFocused || valueNotEmpty) FontWeight.Medium else FontWeight.Normal
  Text(
    text = label,
    style = styleFocused,
    color = color,
    modifier = Modifier.padding(
      horizontal = 4.dp,
    ),
    fontWeight = fontWeight

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
    unfocusedBorderColor = ColorPalette.Outline,
    focusedBorderColor = ColorPalette.Outline,
    errorBorderColor = ColorPalette.Error,
    errorLabelColor = ColorPalette.Error,
    errorLeadingIconColor = ColorPalette.Error,
    errorTrailingIconColor = ColorPalette.Error
  )
}


@Composable
fun CustomClickableTextField(
  value : String,
  onValueChange : (String) -> Unit,
  label : String,
  placeholder : String,
  trailingIcon : @Composable (() -> Unit)? = null,
  modifier : Modifier = Modifier,
  readOnly : Boolean = false,
  expanded : Boolean,
  onClick : () -> Unit
) {
  Box(
    modifier = modifier
      .padding(16.dp)
      .clickable(onClick = onClick)
      .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)) // Menambahkan border
      .background(Color.White, shape = RoundedCornerShape(8.dp)) // Background putih
      .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp) // Padding di dalam Box
  ) {
    Column {
      // Label di atas input
      Text(
        text = label,
        style = TextStyle(
          color = if (expanded) Color.Blue else Color.Gray,
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.align(Alignment.Start)
      )

      Spacer(modifier = Modifier.height(4.dp))

      // Input text di bawah label
      BasicTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = ! readOnly,
        textStyle = TextStyle(fontSize = 16.sp),
        cursorBrush = SolidColor(Color.Black),
        modifier = Modifier.fillMaxWidth()
      )

      // Placeholder jika value kosong
      if (value.isEmpty()) {
        Text(
          text = placeholder,
          style = TextStyle(color = Color.Gray, fontSize = 16.sp),
          modifier = Modifier.align(Alignment.Start)
        )
      }

      // Trailing icon di sebelah kanan
      if (trailingIcon != null) {
        Box(modifier = Modifier.align(Alignment.End)) {
          trailingIcon()
        }
      }
    }
  }
}
