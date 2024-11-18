package com.example.slicingbcf.implementation.peserta.jadwal.bulanan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.data.local.detailJadwal
import com.example.slicingbcf.data.local.profilLembaga
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@Preview(showBackground = true)
@Composable
fun PreviewMonthlyCalendarScreen() {
    val userName = profilLembaga.firstOrNull()?.name ?: "Pengguna"
    val schedule = detailJadwal.groupBy { it.date }.mapValues { entry ->
        entry.value.map {
            "${it.beginTime.formatTime()} - ${it.endTime.formatTime()} WIB ${it.type}" to Color(it.color)
        }
    }

    JadwalMentoringBulanScreen(
        userName = userName,
        schedule = schedule
    )
}

@Composable
fun JadwalMentoringBulanScreen(userName: String, schedule: Map<LocalDate, List<Pair<String, Color>>>) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val today = LocalDate.now()
    val currentMonth = YearMonth.of(selectedDate.year, selectedDate.month)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Halo, $userName",
            style = StyledText.MobileLargeSemibold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Text(
            text = "Hari ini: ${today.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("id", "ID"))}, " +
                    "${today.dayOfMonth} ${today.month.getDisplayName(TextStyle.FULL, Locale("id", "ID"))} ${today.year}",
            style = StyledText.MobileBaseRegular,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.Start,
            color = ColorPalette.Monochrome400
        )

        Spacer(modifier = Modifier.height(32.dp))

        var expanded by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = { selectedDate = today },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = ColorPalette.PrimaryColor700
                ),
                border = BorderStroke(1.dp, ColorPalette.PrimaryColor700),
                modifier = Modifier
                    .height(28.dp)
                    .width(72.dp),
                contentPadding = PaddingValues(horizontal = 1.dp, vertical = 0.dp)
            ) {
                Text(
                    text = "Hari Ini",
                    style = StyledText.MobileXsRegular,
                    textAlign = TextAlign.Center
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                IconButton(onClick = { selectedDate = selectedDate.minusMonths(1) }) {
                    Icon(
                        Icons.Default.ArrowBackIosNew,
                        contentDescription = "Previous Month",
                        modifier = Modifier.size(10.dp)
                    )
                }

                Text(
                    text = currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " ${currentMonth.year}",
                    style = StyledText.MobileSmallRegular,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                IconButton(onClick = { selectedDate = selectedDate.plusMonths(1) }) {
                    Icon(
                        Icons.Default.ArrowForwardIos,
                        contentDescription = "Next Month",
                        modifier = Modifier.size(10.dp)
                    )
                }
            }

            Box(
                Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
            ) {
                TextButton(onClick = { expanded = true }) {
                    Text(
                        text = "Bulan",
                        style = StyledText.MobileXsRegular,
                        color = ColorPalette.Black
                    )
                    Icon(
                        Icons.Default.ArrowRight,
                        contentDescription = "Dropdown for Month",
                        modifier = Modifier.size(24.dp),
                        tint = ColorPalette.Black
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    val currentYear = LocalDate.now().year
                    for (year in currentYear - 5..currentYear + 5) {
                        for (month in 1..12) {
                            val yearMonth = YearMonth.of(year, month)
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "${yearMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} $year",
                                        style = StyledText.MobileSmallRegular
                                    )
                                },
                                onClick = {
                                    selectedDate = yearMonth.atDay(1)
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        MonthlyCalendarView(
            currentMonth = currentMonth,
            today = today,
            selectedDate = selectedDate,
            schedule = schedule,
            onDateSelected = { selectedDate = it }
        )
    }
}
@Composable
fun MonthlyCalendarView(
    currentMonth: YearMonth,
    today: LocalDate,
    selectedDate: LocalDate,
    schedule: Map<LocalDate, List<Pair<String, Color>>>,
    onDateSelected: (LocalDate) -> Unit
) {
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfWeek = (currentMonth.atDay(1).dayOfWeek.value % 7)
    val totalCells = ((daysInMonth + firstDayOfWeek + 6) / 7) * 7

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, ColorPalette.Monochrome200)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(ColorPalette.Monochrome100)
                .border(1.dp, ColorPalette.Monochrome200)
        ) {
            listOf("Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab").forEach { day ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .background(ColorPalette.Success100)
                        .border(1.dp, ColorPalette.Monochrome200),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        style = StyledText.MobileXsBold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        for (week in 0 until (totalCells / 7)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp) // Set the height of each row
                    .border(1.dp, ColorPalette.Monochrome200)
            ) {
                for (day in 0..6) {
                    val dayIndex = week * 7 + day - firstDayOfWeek + 1
                    val date = when {
                        dayIndex < 1 -> currentMonth.minusMonths(1).atEndOfMonth().plusDays(dayIndex.toLong())
                        dayIndex > daysInMonth -> currentMonth.plusMonths(1).atDay(dayIndex - daysInMonth)
                        else -> currentMonth.atDay(dayIndex)
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(1.dp, ColorPalette.Monochrome200)
                            .background(Color.Transparent)
                            .clickable { onDateSelected(date) },
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when (date) {
                                            today -> ColorPalette.PrimaryColor100
                                            selectedDate -> Color.LightGray
                                            else -> Color.Transparent
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = date.dayOfMonth.toString(),
                                    style = StyledText.MobileXsRegular,
                                    color = when {
                                        date.month != currentMonth.month -> ColorPalette.Monochrome500
                                        date == today -> Color.Blue
                                        else -> Color.Black
                                    },
                                    textAlign = TextAlign.Center
                                )
                            }

                            schedule[date]?.forEach { (event, color) ->
                                Box(
                                    modifier = Modifier
                                        .padding(top = 2.dp)
                                        .fillMaxWidth()
                                        .height(16.dp)
                                        .background(color, RoundedCornerShape(4.dp))
                                ) {
                                    Text(
                                        text = event,
                                        style = StyledText.Mobile3xsRegular,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 2.dp),
                                        maxLines = 1
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun java.time.LocalTime.formatTime(): String {
    return this.toString().substring(0, 5).replace(":", ".")
}