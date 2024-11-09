package com.example.slicingbcf.ui.sidenav

import android.util.Log
import com.example.slicingbcf.ui.navigation.Screen

data class DropdownItem(
  val text : String,
  val onClick : () -> Unit
)

fun dropdownItemsPendaftaran(
  navigateAndCloseSideNav : (String) -> Unit
) : List<DropdownItem> {
  return listOf(
    DropdownItem(
      text = "Registrasi Peserta",
      onClick = {
        Log.d("SideNav", "Registrasi Peserta clicked")
      }
    ),
    DropdownItem(
      text = "Cek Status Peserta",
      onClick = {
        Log.d("SideNav", "Cek Status Peserta clicked")
      }
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
      }
    ),
    DropdownItem(
      text = "Penilaian Peserta",
      onClick = {
        Log.d("SideNav", "Penilaian Peserta clicked")
      }
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
      }
    ),
    DropdownItem(
      text = "Umpan Balik Mentor",
      onClick = {
        Log.d("SideNav", "Umpan Balik Mentor clicked")
      }
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
      }
    ),
    DropdownItem(
      text = "Laporan",
      onClick = {
        Log.d("SideNav", "Laporan clicked")
      }
    ),
    DropdownItem(
      text = "Lembar Kerja",
      onClick = {
        Log.d("SideNav", "Lembar Kerja clicked")
      }
    ),
    DropdownItem(
      text = "Lembar Kerja",
      onClick = {
        Log.d("SideNav", "Lembar Kerja clicked")
      }
    ),
    DropdownItem(
      text = "Pitch Deck",
      onClick = {
        Log.d("SideNav", "Pitch Deck clicked")
      }
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
      }
    ),
    DropdownItem(
      text = "Umpan Balik Kegiatan",
      onClick = {
        Log.d("SideNav", "Umpan Balik Kegiatan clicked")
      }
    )
  )
}
