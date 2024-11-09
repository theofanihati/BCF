package com.example.slicingbcf.ui.sidenav

import android.util.Log
import com.example.slicingbcf.ui.navigation.Screen

data class DropdownItem(
  val text : String,
  val onClick : () -> Unit,
  val route : String?
)

fun dropdownItemsPendaftaran(
  navigateAndCloseSideNav : (String) -> Unit
) : List<DropdownItem> {
  return listOf(
    DropdownItem(
      text = "Registrasi Peserta",
      onClick = {
        Log.d("SideNav", "Registrasi Peserta clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Cek Status Peserta",
      onClick = {
        Log.d("SideNav", "Cek Status Peserta clicked")
      },
      route = null
    )
  )
}

fun dropdownItemsPeserta(
  navigateAndCloseSideNav : (String) -> Unit
) : List<DropdownItem> {
  return listOf(
    DropdownItem(
      text = "Data Peserta",
      onClick = {
        navigateAndCloseSideNav(Screen.Peserta.DataPeserta.route)
      },
      route = Screen.Peserta.DataPeserta.route
    ),
    DropdownItem(
      text = "Penilaian Peserta",
      onClick = {
        Log.d("SideNav", "Penilaian Peserta clicked")
      },
      route = null
    )
  )
}

fun dropdownItemsMentor(
  navigateAndCloseSideNav : (String) -> Unit
) : List<DropdownItem> {
  return listOf(
    DropdownItem(
      text = "Kelompok Mentor",
      onClick = {
        Log.d("SideNav", "Kelompok Mentor clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Umpan Balik Mentor",
      onClick = {
        Log.d("SideNav", "Umpan Balik Mentor clicked")
      },
      route = null
    )
  )
}

fun dropdownItemsTugas(
  navigateAndCloseSideNav : (String) -> Unit
) : List<DropdownItem> {
  return listOf(
    DropdownItem(
      text = "Modul",
      onClick = {
        Log.d("SideNav", "Modul clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Laporan",
      onClick = {
        Log.d("SideNav", "Laporan clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Lembar Kerja",
      onClick = {
        Log.d("SideNav", "Lembar Kerja clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Lembar Kerja",
      onClick = {
        Log.d("SideNav", "Lembar Kerja clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Pitch Deck",
      onClick = {
        Log.d("SideNav", "Pitch Deck clicked")
      },
      route = null
    ),
  )
}

fun dropdownItemsKegiatan(
  navigateAndCloseSideNav : (String) -> Unit
) : List<DropdownItem> {
  return listOf(
    DropdownItem(
      text = "Jadwal Kegiatan",
      onClick = {
        Log.d("SideNav", "Jadwal Kegiatan clicked")
      },
      route = null
    ),
    DropdownItem(
      text = "Umpan Balik Kegiatan",
      onClick = {
        Log.d("SideNav", "Umpan Balik Kegiatan clicked")
      },
      route = null
    )
  )
}
