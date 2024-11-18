package com.example.slicingbcf.implementation.peserta.form_feedback_mentor

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText

@Composable
@Preview(showSystemUi = true)
fun FeedbackMentorScreen1(
    modifier: Modifier = Modifier
) {
    var selectedEvaluasi by remember { mutableStateOf("Pilih evaluasi capaian mentoring") }
    var namaMentor by remember { mutableStateOf(TextFieldValue("")) }
    var selectedPeriode by remember { mutableStateOf("Pilih periode capaian mentoring") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        TopSection(
            selectedEvaluasi = selectedEvaluasi,
            onEvaluasiChange = { selectedEvaluasi = it },
            namaMentor = namaMentor,
            onNamaMentorChange = { namaMentor = it },
            selectedPeriode = selectedPeriode,
            onPeriodeChange = { selectedPeriode = it }
        )
        BottomSection()
    }
}

@Composable
fun TopSection(
    selectedEvaluasi: String,
    onEvaluasiChange: (String) -> Unit,
    namaMentor: TextFieldValue,
    onNamaMentorChange: (TextFieldValue) -> Unit,
    selectedPeriode: String,
    onPeriodeChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Umpan Balik Mentor",
            style = StyledText.MobileLargeSemibold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Dropdown Evaluasi Capaian Mentoring
        Text(
            text = "Evaluasi Capaian Mentoring",
            style = StyledText.MobileBaseSemibold,
            textAlign = TextAlign.Left,
            color = ColorPalette.PrimaryColor700,
        )
        DropdownButton(
            text = selectedEvaluasi,
            onClick = { /* TODO: LOGIC ON CLICK NYA */ }
        )

        // Input Field Nama Mentor
        Text(
            text = "Nama Mentor",
            style = StyledText.MobileBaseSemibold,
            textAlign = TextAlign.Left,
            color = ColorPalette.PrimaryColor700,
        )
        OutlinedTextField(
            value = namaMentor,
            onValueChange = onNamaMentorChange,
            placeholder = {
                Text(
                    text = "Ketik nama mentor anda disini...",
                    style = StyledText.MobileSmallRegular,
                    color = ColorPalette.Monochrome400
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = ColorPalette.Monochrome900,
                focusedIndicatorColor = ColorPalette.Monochrome900
            ),
            singleLine = true
        )

        // Dropdown Periode Capaian Mentoring
        Text(
            text = "Periode Capaian Mentoring",
            style = StyledText.MobileBaseSemibold,
            textAlign = TextAlign.Left,
            color = ColorPalette.PrimaryColor700,
        )
        DropdownButton(
            text = selectedPeriode,
            onClick = { /* TODO: logic on click dropdown */ }
        )
    }
}

@Composable
fun BottomSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            modifier = Modifier
                .width(300.dp)
                .height(40.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = {
                    /* TODO: logic "Kembali" kemana */
                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = MaterialTheme.shapes.extraLarge,
                border = BorderStroke(1.dp, ColorPalette.PrimaryColor700),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = ColorPalette.PrimaryColor700
                )
            ) {
                Text(text = "Kembali", style = StyledText.MobileBaseSemibold)
            }

            Button(
                onClick = {
                    // TODO: logic "Berikutnya" kemana
                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorPalette.PrimaryColor700,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Berikutnya", style = StyledText.MobileBaseSemibold)
            }
        }
    }
}

@Composable
fun DropdownButton(
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(1.dp, ColorPalette.Monochrome900),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = text,
                style = StyledText.MobileSmallRegular,
                color = if (text == "Pilih evaluasi capaian mentoring" || text == "Pilih periode capaian mentoring") ColorPalette.Monochrome400 else ColorPalette.Monochrome900,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Icon",
                tint = ColorPalette.Monochrome900,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}
