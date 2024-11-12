package com.example.slicingbcf.implementation.peserta.pitch_deck

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.data.local.PitchDeck
import com.example.slicingbcf.data.local.pitchDeck
import java.text.SimpleDateFormat
import java.util.*

@Composable
@Preview(showSystemUi = true)
fun PitchDeckDetailScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val currentPitchDeck = pitchDeck.first()
        TopSection(pitchDeck = currentPitchDeck)
    }
}

@Composable
fun TopSection(
    pitchDeck: PitchDeck
) {
    var lastModified by remember { mutableStateOf(getCurrentTimePitchDeck()) }
    val currentContext = LocalContext.current
    val isLate = checkIfLate(pitchDeck.submissionDeadline)

    Text(
        text = "Submisi Pitch Deck",
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    InfoRow(label = "Judul Lembar Kerja", value = pitchDeck.title)
    InfoRow(label = "Batch", value = pitchDeck.batch.toString())
    InfoRow(label = "Deskripsi Lembar Kerja", value = pitchDeck.description)

    Text(
        text = "Tautan Lembar Kerja",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pitchDeck.link))
                currentContext.startActivity(intent)
            }
            .padding(vertical = 4.dp),
        textDecoration = TextDecoration.Underline
    )

    InfoRow(
        label = "Batas Submisi Lembar Kerja",
        value = pitchDeck.submissionDeadline,
        valueColor = if (isLate) Color.Red else Color.Black
    )

    InfoRow(
        label = "Terakhir Diubah",
        value = lastModified,
        valueColor = if (isLate) Color.Red else Color.Black
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { lastModified = getCurrentTimePitchDeck() },
        modifier = Modifier
    ) {
        Text("Submit Tugas")
    }
}

@Composable
fun InfoRow(
    label: String,
    value: String,
    valueColor: Color = Color.Black
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = valueColor
        )
    }
}

fun getCurrentTimePitchDeck(): String {
    val timeFormat = SimpleDateFormat("EEEE, d MMM yyyy HH:mm", Locale.getDefault())
    return timeFormat.format(Date())
}

fun checkIfLate(deadline: String): Boolean {
    val dateFormat = SimpleDateFormat("EEEE, d MMM yyyy HH:mm", Locale.getDefault())
    val deadlineDate = dateFormat.parse(deadline)
    val currentTime = Date()
    return currentTime.after(deadlineDate)
}
