package com.example.slicingbcf.implementation.peserta.data_peserta

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicingbcf.R
import com.example.slicingbcf.constant.ColorPalette
import com.example.slicingbcf.constant.StyledText
import com.example.slicingbcf.data.local.Participant
import com.example.slicingbcf.data.local.participants
import com.example.slicingbcf.data.local.toColor
import com.example.slicingbcf.data.local.toDisplayText
<<<<<<< HEAD
import kotlin.math.ceil

// TODO: WILL BE REFACTORED
=======
import com.example.slicingbcf.ui.shared.textfield.SearchBarCustom
>>>>>>> source-repo/main

@Composable
@Preview(showSystemUi = true)
fun DataPesertaScreen(
  modifier : Modifier = Modifier
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(28.dp),
  ) {
    TopSection()
    BottomSection(
      participants = participants,
      headers = headers
    )
  }
}


@Composable
fun TopSection() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        horizontal = 16.dp
      ),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Text(
      text = "Data Peserta",
      style = StyledText.MobileLargeSemibold,
      textAlign = TextAlign.Center,
      modifier = Modifier.fillMaxWidth()
    )

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      SearchBarCustom(
      )

      SmallFloatingActionButton(
        onClick = { Log.d("filter", "filter clicked") },
        modifier = Modifier.size(40.dp),
        containerColor = ColorPalette.PrimaryColor100
      ) {
        Image(
          painter = painterResource(id = R.drawable.filter),
          contentDescription = "Filter",
          modifier = Modifier.size(20.dp)
        )
      }

      SmallFloatingActionButton(
        onClick = { Log.d("download", "download clicked") },
        modifier = Modifier.size(40.dp),
        containerColor = ColorPalette.PrimaryColor700
      ) {
        Image(
          painter = painterResource(id = R.drawable.download),
          contentDescription = "Download",
          modifier = Modifier.size(20.dp)
        )
      }
    }
  }
}

@Composable
<<<<<<< HEAD
fun SearchBarCustom() {
  var query by remember { mutableStateOf("") }

  TextField(
    textStyle = StyledText.MobileSmallRegular,

    value = query,
    onValueChange = { query = it },

    placeholder = {
      Text(
        "Cari Pertanyaan",
        style = StyledText.MobileSmallRegular,
      )
    },
    leadingIcon = {
      Icon(
        Icons.Default.Search,
        contentDescription = "Search Icon",
        modifier = Modifier.size(20.dp)
      )
    },
    singleLine = true,
    shape = MaterialTheme.shapes.medium,
    colors = TextFieldDefaults.colors(
      // ! biar ga ada default border bottom
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      disabledIndicatorColor = Color.Transparent,
      errorIndicatorColor = Color.Transparent,
      unfocusedContainerColor = ColorPalette.PrimaryColor100,
      focusedContainerColor = ColorPalette.PrimaryColor100,
      )

  )
}

@Composable
fun BottomSection(participants : List<Participant>, headers : List<Header>) {
  var currentPage by remember { mutableIntStateOf(1) }
  var itemsPerPage by remember { mutableIntStateOf(5) }
  val totalItems = participants.size
  val totalPages = ceil(totalItems.toFloat() / itemsPerPage).toInt()

  LaunchedEffect(itemsPerPage) {
    currentPage = 1
  }

  // Hitung data yang ditampilkan di halaman saat ini
  val startIndex = (currentPage - 1) * itemsPerPage
  val endIndex = minOf(startIndex + itemsPerPage, totalItems)
  val currentPageItems = participants.subList(startIndex, endIndex)

=======
fun BottomSection(
  participants : List<Participant>,
  headers : List<Header>,
  currentPage : Int,
  totalPage : Int,
  totalData : Int,
  itemsPerPage : Int,
  onPageClick : (Int) -> Unit,
  onPreviousClick : () -> Unit,
  onNextClick : () -> Unit,
  onLimitChange : (Int) -> Unit
) {
>>>>>>> source-repo/main
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    ScrollableTable(headers, currentPageItems)
    CustomPagination(
      pagination = Pagination(
        currentPage = currentPage,
        totalPage = totalPages,
        totalData = totalItems,
        limit = itemsPerPage
      ),
      onPageClick = { newPage ->
        currentPage = newPage
      },
      onPreviousClick = {
        if (currentPage > 1) {
          currentPage --
        }
      },
      onNextClick = {
        if (currentPage < totalPages) {
          currentPage ++
        }
      },
      onLimitChange = { newLimit ->
        itemsPerPage = newLimit
      }
    )
  }
}

@Composable
fun CustomPagination(
  pagination : Pagination,
  onPageClick : (Int) -> Unit,
  onPreviousClick : () -> Unit,
  onNextClick : () -> Unit,
  onLimitChange : (Int) -> Unit
) {
  val (currentPage, totalPage, totalData, limit) = pagination
  val displayedPages = calculatePageRange(currentPage, totalPage)
  var showLimitDialog by remember { mutableStateOf(false) }
  val limitOptions = listOf(5, 10, 15, 20)
  var selectedLimit by remember { mutableIntStateOf(limit) }

  Column(
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      PaginationIcon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "Previous",
        isEnabled = currentPage > 1,
        onClick = onPreviousClick
      )

      Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        displayedPages.forEach { number ->
          PageNumberBox(
            number = number,
            isSelected = number == currentPage,
            onClick = { onPageClick(number) }
          )
        }
      }

      PaginationIcon(
        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
        contentDescription = "Next",
        isEnabled = currentPage < totalPage,
        onClick = onNextClick
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
        text = "${(currentPage - 1) * limit + 1}-${
          minOf(
            currentPage * limit,
            totalData
          )
        } dari $totalData item",
        style = StyledText.MobileXsRegular,
        color = ColorPalette.Monochrome500
      )

      if (showLimitDialog) {
        AlertDialog(
          onDismissRequest = { showLimitDialog = false },
          title = { Text("Pilih Jumlah Baris") },
          text = {
            Column {
              limitOptions.forEach { option ->
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                      selectedLimit = option
                      onLimitChange(option)
                      showLimitDialog = false
                    }
                    .padding(vertical = 8.dp),
                  horizontalArrangement = Arrangement.Center
                ) {
                  Text(
                    text = "$option baris",
                    style = StyledText.MobileSmallRegular,
                    color = if (option == selectedLimit) ColorPalette.Blue else ColorPalette.Monochrome900
                  )
                }
              }
            }
          },
          confirmButton = {},
          dismissButton = {}
        )
      }

      Box(
        modifier = Modifier.clickable { showLimitDialog = true }
      ) {
        Text(
          text = "$selectedLimit baris",
          style = StyledText.MobileXsRegular,
          color = ColorPalette.Blue
        )
      }
    }
  }
}

@Composable
fun PaginationIcon(
  imageVector : ImageVector,
  contentDescription : String,
  isEnabled : Boolean,
  onClick : () -> Unit
) {
  Icon(
    imageVector = imageVector,
    contentDescription = contentDescription,
    modifier = Modifier
      .size(12.dp)
      .clickable(enabled = isEnabled) { onClick() }
      .alpha(if (isEnabled) 1f else 0.3f)
  )
}

@Composable
fun PageNumberBox(
  number : Int,
  isSelected : Boolean,
  onClick : () -> Unit
) {
  val displayText = if (number == ELLIPSIS) "..." else number.toString()
  Box(
    modifier = Modifier
      .background(
        color = if (isSelected) ColorPalette.Yellow else Color.Transparent,
        shape = CircleShape
      )
      .padding(horizontal = 12.dp, vertical = 6.dp)
      .clickable(enabled = number != ELLIPSIS) { onClick() },
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = displayText,
      style = StyledText.MobileXsRegular,
      color = if (isSelected) ColorPalette.OnPrimary else ColorPalette.Monochrome500
    )
  }
}

// Special value representing an ellipsis ("...") in the pagination
private const val ELLIPSIS = - 1

fun calculatePageRange(currentPage : Int, totalPage : Int) : List<Int> {
  return when {
    totalPage <= 5               -> (1..totalPage).toList()
    currentPage <= 3             -> listOf(1, 2, 3, 4, 5, ELLIPSIS, totalPage)
    currentPage >= totalPage - 2 -> listOf(
      1,
      ELLIPSIS,
      totalPage - 4,
      totalPage - 3,
      totalPage - 2,
      totalPage - 1,
      totalPage
    )

    else                         -> listOf(
      1,
      ELLIPSIS,
      currentPage - 1,
      currentPage,
      currentPage + 1,
      ELLIPSIS,
      totalPage
    )
  }
}


data class Pagination(
  val currentPage : Int,
  val totalPage : Int,
  val totalData : Int,
  val limit : Int,
)


// TODO: will be refactored, bakal jadi reusable table
@Composable
fun ScrollableTable(headers : List<Header>, participants : List<Participant>) {
  val scrollState = rememberScrollState()

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .horizontalScroll(scrollState)
  ) {
    Column {
      HeaderRow(headers)
      participants.forEachIndexed { index, participant ->
        ParticipantRow(participant, index)
      }
    }
  }
}

@Composable
fun HeaderRow(headers : List<Header>) {
  Row(
    modifier = Modifier
      .background(ColorPalette.PrimaryColor100)
  ) {
    headers.forEach { header ->
      TableCell(
        text = header.name,
        isHeader = true,
        weight = header.weight
      )
    }
  }
}

@Composable
fun ParticipantRow(participant : Participant, index : Int) {
  val backgroundColor = if (index % 2 == 0) {
    MaterialTheme.colorScheme.surface
  } else {
    MaterialTheme.colorScheme.surfaceVariant
  }

  Row(
    modifier = Modifier
      .background(backgroundColor)
  ) {
    TableCell(text = participant.namaLembaga, weight = 1.5f)
    TableCell(text = participant.batch.toString(), weight = 0.7f)
    TableCell(text = participant.provinsi, weight = 1f)
    TableCell(
      text = participant.status.toDisplayText(),
      weight = 1f,
      color = participant.status.toColor()
    )
  }
}

@Composable
fun TableCell(
  text : String,
  isHeader : Boolean = false,
  weight : Float,
  color : Color = ColorPalette.Monochrome900
) {
  Text(
    text = text,
    style = if (isHeader) StyledText.MobileXsBold else StyledText.MobileXsRegular,
    color = color,
    modifier = Modifier
      .width(120.dp * weight)
      .padding(8.dp)
  )
}


data class Header(
  val name : String,
  val weight : Float
)

val headers = listOf(
  Header("Nama Lembaga", 1.5f),
  Header("Batch", 0.7f),
  Header("Provinsi", 1f),
  Header("Status", 1f)
)
