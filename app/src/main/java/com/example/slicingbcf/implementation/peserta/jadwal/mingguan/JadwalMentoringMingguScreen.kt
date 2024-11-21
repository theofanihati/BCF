package com.example.slicingbcf.implementation.peserta.jadwal.mingguan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import java.time.LocalTime
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@Preview(showBackground = true)
@Composable
fun PreviewWeeklyCalendarScreen() {
    val userName = profilLembaga.firstOrNull()?.name ?: "Pengguna"
    val schedule = detailJadwal.groupBy { it.date }.mapValues { entry ->
        entry.value.map { (it.beginTime to it.endTime) to it.title }
    }

    JadwalMentoringMingguScreen(
        userName = profilLembaga.firstOrNull()?.name ?: "Pengguna",
        schedule = schedule
    )
}

@Composable
fun JadwalMentoringMingguScreen(
    userName: String,
    schedule: Map<LocalDate, List<Pair<Pair<LocalTime, LocalTime>, String>>>
) {
    var selectedWeekStart by remember { mutableStateOf(LocalDate.now().withDayOfWeek(7)) }
    val today = LocalDate.now()
    val weekDates = (0 until 7).map { selectedWeekStart.plusDays(it.toLong()) }
    var selectedWeek by remember { mutableStateOf(LocalDate.now().withDayOfWeek(1)) }
    val currentWeekDates = (0..6).map { selectedWeek.plusDays(it.toLong()) }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val currentMonth = YearMonth.of(selectedDate.year, selectedDate.month)
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ){
        Spacer(modifier = Modifier.height(80.dp))
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
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = ColorPalette.Monochrome400
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            Modifier
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
                horizontalArrangement = Arrangement.spacedBy(-4.dp),
                modifier = Modifier.padding(0.dp)
            ) {
                IconButton(onClick = { selectedWeek = selectedWeek.minusWeeks(1) }) {
                    Icon(
                        Icons.Default.ArrowBackIosNew,
                        contentDescription = "Previous Month",
                        modifier = Modifier.size(10.dp)
                    )
                }
                Column(){
                    Text(
                        text = currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " ${currentMonth.year}",
                        style = StyledText.MobileSmallSemibold,
                    )
                    Text(
                        text = "${currentWeekDates.first()} - ${currentWeekDates.last()}",
                        style = StyledText.Mobile2xsRegular
                    )
                }

                IconButton(
                    onClick = { selectedDate = selectedDate.plusWeeks(1)}
                    ) {
                    Icon(
                        Icons.Default.ArrowForwardIos,
                        contentDescription = "Next Month",
                        modifier = Modifier
                            .size(10.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(0.dp)
            ) {
                TextButton(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .width(75.dp)
                        .padding(6.dp)
                ) {
                    Text(
                        text = "Pekan",
                        style = StyledText.MobileXsRegular,
                        color = ColorPalette.Black
                    )
                    Icon(
                        Icons.Default.ArrowRight,
                        contentDescription = "Dropdown for Month",
                        modifier = Modifier.size(24.dp),
                        tint = ColorPalette.Black)
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    val currentDate = LocalDate.now()
                    val startYear = currentDate.year - 1
                    val endYear = currentDate.year + 1

                    for (year in startYear..endYear) {
                        for (week in 1..52) {
                            val firstDayOfWeek = LocalDate.ofYearDay(year, (week - 1) * 7 + 1).withDayOfWeek(1)
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "Pekan ${week} (${firstDayOfWeek.formatIndonesian()} - ${firstDayOfWeek.plusDays(6).formatIndonesian()})",
                                        style = StyledText.MobileSmallRegular
                                    )
                                },
                                onClick = {
                                    selectedWeekStart = firstDayOfWeek
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        WeeklyCalendarView(
            weekDates = weekDates,
            schedule = schedule
        )
        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Composable
fun WeeklyCalendarView(
    weekDates: List<LocalDate>,
    schedule: Map<LocalDate, List<Pair<Pair<LocalTime, LocalTime>, String>>>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Header Row (Days of Week)
        Row(
            Modifier
                .fillMaxWidth()
                .background(ColorPalette.Monochrome100)
        ) {
            Spacer(modifier = Modifier.width(48.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp
                        )
                    )
            ) {
                weekDates.forEach { date ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .background(ColorPalette.Success100)
                            .border(1.dp, ColorPalette.Monochrome200),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("id", "ID"))}\n${date.dayOfMonth}",
                            textAlign = TextAlign.Center,
                            style = StyledText.MobileSmallRegular
                        )
                    }
                }
            }
        }

        (0..23).forEach { hour ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .border(1.dp, ColorPalette.Monochrome200)
            ) {
                Text(
                    text = "${hour.toString().padStart(2, '0')}:00",
                    modifier = Modifier
                        .width(48.dp)
                        .padding(top = 16.dp),
                    style = StyledText.MobileXsRegular,
                    textAlign = TextAlign.Center
                )

                weekDates.forEach { date ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .background(Color.Transparent)
                            .border(1.dp, ColorPalette.Monochrome200)
                    ) {
                        val events = schedule[date]?.filter { event ->
                            val (start, end) = event.first
                            hour in start.hour until end.hour
                        }

                        events?.forEach { event ->
                            val (timeRange, title) = event
                            val (beginTime, endTime) = timeRange
                            val eventColor = detailJadwal.find { it.title == title && it.beginTime == beginTime && it.endTime == endTime }?.color?.let { Color(it) } ?: ColorPalette.Monochrome100
                            val eventTime = "${beginTime.formatTime()} - ${endTime.formatTime()} WIB"

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                                    .padding(2.dp)
                                    .background(eventColor)
                            ) {
                                Text(
                                    text = "$eventTime $title",
                                    style = StyledText.Mobile3xsRegular,
                                    color = Color.White,
                                    modifier = Modifier.padding(4.dp),
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


fun LocalDate.withDayOfWeek(day: Int): LocalDate {
    val adjustedDay = if (this.dayOfWeek.value == 7) 0 else this.dayOfWeek.value
    return this.minusDays((adjustedDay - (day % 7)).toLong())
}
fun LocalTime.formatTime(): String {
    return this.toString().substring(0, 5).replace(":", ".")
}

fun LocalDate.formatIndonesian(): String {
    val day = this.dayOfMonth
    val month = this.month.getDisplayName(TextStyle.FULL, Locale("id", "ID"))
    val year = this.year
    return "$day $month $year"
}