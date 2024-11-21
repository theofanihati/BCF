package com.example.slicingbcf.implementation.peserta.form_feedback_mini_training

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
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
import com.example.slicingbcf.implementation.peserta.form_feedback_mentor.RatingSections

@Composable
@Preview(showSystemUi = true)
fun FormMiniTrainingScreen(
    modifier: Modifier = Modifier,
    onSaveFeedback: (String, String, String, String, String) -> Unit = { _, _, _, _, _ -> }
) {
    var dateOfEvent by remember { mutableStateOf("") }
    var speaker1Name by remember { mutableStateOf(TextFieldValue("")) }
    var speaker2Name by remember { mutableStateOf(TextFieldValue("")) }
    var eventDate by remember { mutableStateOf(TextFieldValue("")) }
    var kritikSaran by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        Text(
            text = "Submisi Pitch Deck",
            style = StyledText.MobileLargeSemibold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        )

        StyledDropdownField(
            label = "Hari Kegiatan Mentoring",
            value = dateOfEvent,
            onClick = {
                // TODO: LOGIC PILIH TANGGAL
            }
        )

        StyledInputField(
            label = "Nama Pemateri 1",
            value = speaker1Name,
            placeholder = "Masukkan nama pemateri",
            onValueChange = { speaker1Name = it }
        )

        StyledInputField(
            label = "Nama Pemateri 2",
            value = speaker2Name,
            placeholder = "Masukkan nama pemateri",
            onValueChange = { speaker2Name = it }
        )

        StyledInputField(
            label = "Tanggal Kegiatan",
            value = eventDate,
            placeholder = "DD/MM/YYYY",
            onValueChange = { eventDate = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Apakah materi yang disampaikan pembicara mudah dipahami?",
            style = StyledText.MobileBaseSemibold,
            color = ColorPalette.PrimaryColor700,
            textAlign = TextAlign.Justify,
        )

        (1..2).forEach { speakerNumber ->
            FeedbackEvaluationSection(
                speakerLabel = "Pemateri $speakerNumber",
            )
        }

        Text(
            text = "Apakah pembicara mampu mengatur waktu dengan baik?",
            style = StyledText.MobileBaseSemibold,
            color = ColorPalette.PrimaryColor700,
            textAlign = TextAlign.Justify,
        )

        (1..2).forEach { speakerNumber ->
            FeedbackEvaluationSection(
                speakerLabel = "Pemateri $speakerNumber",
            )
        }

        Text(
            text = "Apakah pembicara memberikan jawaban yang memuaskan atas pertanyaan peserta?",
            style = StyledText.MobileBaseSemibold,
            color = ColorPalette.PrimaryColor700,
            textAlign = TextAlign.Justify,
        )

        (1..2).forEach { speakerNumber ->
            FeedbackEvaluationSection(
                speakerLabel = "Pemateri $speakerNumber",
            )
        }

        Text(
            text = "Apakah pembicara menggunakan metode yang interaktif?",
            style = StyledText.MobileBaseSemibold,
            color = ColorPalette.PrimaryColor700,
            textAlign = TextAlign.Justify,
        )

        (1..2).forEach { speakerNumber ->
            FeedbackEvaluationSection(
                speakerLabel = "Pemateri $speakerNumber",
            )
        }

        KritikSaranInputField(
            label = "Silakan berikan kritik dan saran Anda mengenai kualitas sesi Mini Training secara keseluruhan",
            placeholder = "Tuliskan kritik dan saran setelah mengikuti kegiatan Mini Training hari ini!",
            value = kritikSaran,
            onValueChange = { kritikSaran = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onSaveFeedback(
                    dateOfEvent,
                    speaker1Name.text,
                    speaker2Name.text,
                    kritikSaran.text,
                    eventDate.text
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorPalette.PrimaryColor700,
                contentColor = Color.White
            )
        ) {
            Text("Simpan", style = StyledText.MobileBaseSemibold)
        }
        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Composable
fun StyledInputField(
    label: String,
    value: TextFieldValue,
    placeholder: String,
    onValueChange: (TextFieldValue) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    style = StyledText.MobileSmallRegular,
                    color = ColorPalette.Monochrome400
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(56.dp),
            shape = RoundedCornerShape(50),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = ColorPalette.Monochrome400,
                focusedIndicatorColor = ColorPalette.PrimaryColor700
            ),
            singleLine = true
        )
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .offset(y = (-3).dp)
                .background(Color.White)
        ) {
            Row{
                Text(
                    text = "$label",
                    style = StyledText.MobileBaseSemibold,
                    color = ColorPalette.PrimaryColor700,
                )
                Text(
                    text = "*",
                    style = StyledText.MobileBaseSemibold,
                    color = ColorPalette.Error,
                )
            }
        }
    }
}

@Composable
fun StyledDropdownField(
    label: String,
    value: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, ColorPalette.Monochrome400),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (value.isEmpty()) "Pilih Hari" else value,
                    style = StyledText.MobileSmallRegular,
                    color = if (value.isEmpty()) ColorPalette.Monochrome400 else ColorPalette.Monochrome900
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = ColorPalette.Monochrome900
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .offset(y = (-10).dp)
                .background(Color.White)
        ) {
            Row{
                Text(
                    text = "$label",
                    style = StyledText.MobileBaseSemibold,
                    color = ColorPalette.PrimaryColor700,
                )
                Text(
                    text = "*",
                    style = StyledText.MobileBaseSemibold,
                    color = ColorPalette.Error,
                )
            }

        }
    }
}

@Composable
fun FeedbackEvaluationSection(
    speakerLabel: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val labelPemateri = listOf(
            speakerLabel
        )

        labelPemateri.forEach { question ->
            RatingSections(
                title = question,
                rating = 0,
                onRatingSelected = { /* TODO: Handle rating */ }
            )
        }
    }
}

@Composable
fun KritikSaranInputField(
    label: String,
    placeholder: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .offset(y = (-3).dp)
                .background(Color.White)
        ) {
            Row{
                Text(
                    text = label,
                    style = StyledText.MobileBaseSemibold,
                    color = ColorPalette.PrimaryColor700,
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = "*",
                    style = StyledText.MobileBaseSemibold,
                    color = ColorPalette.Error,
                )
            }
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    style = StyledText.MobileSmallRegular,
                    color = ColorPalette.Monochrome400
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = ColorPalette.Monochrome400,
                focusedIndicatorColor = ColorPalette.PrimaryColor700
            )
        )
    }
}
