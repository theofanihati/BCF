package com.example.slicingbcf.implementation.peserta.jadwal.bulanan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.data.local.profilLembaga
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@Preview(showBackground = true)
@Composable
fun PreviewMonthlyCalendarScreen() {
    val userName = profilLembaga.firstOrNull()?.name ?: "Pengguna"
    val dummySchedule = mapOf(
        LocalDate.of(2024, 11, 24) to listOf(
            "09.00 - Meeting" to Color(0xFF8E24AA),
            "15.00 - Presentation" to Color(0xFF26A69A)
        ),
        LocalDate.of(2024, 11, 16) to listOf(
            "10.00 - Workshop" to Color(0xFF8E24AA),
            "14.00 - Mentor Meeting" to Color(0xFF26A69A)
        )
    )

    JadwalMentoringBulanScreen(
        userName = userName,
        schedule = dummySchedule
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
            ){
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

        CalendarView(
            currentMonth = currentMonth,
            today = today,
            selectedDate = selectedDate,
            schedule = schedule,
            onDateSelected = { selectedDate = it }
        )
    }
}

@Composable
fun CalendarView(
    currentMonth: YearMonth,
    today: LocalDate,
    selectedDate: LocalDate,
    schedule: Map<LocalDate, List<Pair<String, Color>>>,
    onDateSelected: (LocalDate) -> Unit
) {
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfWeek = currentMonth.atDay(1).dayOfWeek.value % 7
    val prevMonth = currentMonth.minusMonths(1)
    val nextMonth = currentMonth.plusMonths(1)
    val daysInPrevMonth = prevMonth.lengthOfMonth()

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .drawBehind {
                val rowHeight = size.height / ((daysInMonth + firstDayOfWeek + 6) / 7 + 2)
                val columnWidth = size.width / 7
                val strokeWidth = 1.dp.toPx()

                for (i in 0..((daysInMonth + firstDayOfWeek) / 7 + 1)) {
                    val y = i * rowHeight
                    drawLine(
                        color = ColorPalette.Monochrome700,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                }
                for (i in 0..7) {
                    val x = i * columnWidth
                    drawLine(
                        color = ColorPalette.Monochrome700,
                        start = Offset(x, 0f),
                        end = Offset(x, size.height),
                        strokeWidth = strokeWidth
                    )
                }
                drawRoundRect(
                    color = ColorPalette.Monochrome700,
                    size = size,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx()),
                    style = Stroke(width = strokeWidth)
                )
            }
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background((ColorPalette.PrimaryColor100).copy(alpha = 0.5f))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab").forEach { day ->
                Text(
                    text = day,
                    style = StyledText.MobileXsBold,
                    modifier = Modifier.weight(1f).padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        for (week in 0 until ((daysInMonth + firstDayOfWeek) / 7 + 1)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                for (day in 0..6) {
                    val dayOfMonth = week * 7 + day - firstDayOfWeek + 1
                    val date = when {
                        dayOfMonth < 1 -> prevMonth.atDay(daysInPrevMonth + dayOfMonth)
                        dayOfMonth > daysInMonth -> nextMonth.atDay(dayOfMonth - daysInMonth)
                        else -> currentMonth.atDay(dayOfMonth)
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .aspectRatio(1f)
                            .clickable { onDateSelected(date) }
                    ) {
                        if (date.month == currentMonth.month) {
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
                                    color = if (date == today) Color.Blue else Color.Black,
                                    style = StyledText.MobileXsRegular,
                                    textAlign = TextAlign.Center
                                )
                            }
                        } else {
                            Text(
                                text = date.dayOfMonth.toString(),
                                color = ColorPalette.Monochrome500,
                                style = StyledText.MobileXsRegular,
                                textAlign = TextAlign.Center
                            )
                        }
                        schedule[date]?.let { events ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(top = 36.dp)
                            ) {
                                events.forEach { (event, color) ->
                                    Box(
                                        modifier = Modifier
                                            .background(color, RoundedCornerShape(8.dp))
                                            .padding(horizontal = 0.dp, vertical = 0.dp)
                                    ) {
                                        Text(
                                            text = event,
                                            color = Color.White,
                                            style = StyledText.Mobile3xsRegular
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

//        schedule[selectedDate]?.let {
//            it.forEach { event ->
//                Text(
//                    text = event,
//                    style = MaterialTheme.typography.bodySmall,
//                    color = Color.Green,
//                    modifier = Modifier.padding(vertical = 2.dp)
//                )
//            }
//        }
    }
}

