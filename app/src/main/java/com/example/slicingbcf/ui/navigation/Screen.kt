package com.example.slicingbcf.ui.navigation

sealed class Screen(val route : String) {

  object Home : Screen("home")

  sealed class Auth(route : String) : Screen(route) {
    object Login : Auth("login")
    object ForgotPassword : Auth("forgot-password")
  }

  sealed class Peserta(route : String) : Screen(route) {
    object DataPeserta : Peserta("data-peserta")
    object KelompokMentoring : Peserta("kelompok-mentoring")
    object PengumumanPeserta : Peserta("pengumuman-peserta")
    data class DetailPengumumanPeserta(val id : String) : Peserta("pengumuman-peserta/$id")
    object WorksheetPeserta : Peserta("worksheet-peserta")
    data class DetailWorksheetPeserta(val id : String) : Peserta("worksheet-peserta/$id")
    object Pengaturan : Peserta("pengaturan")
    object PusatInformasi : Mentor("pusat-informasi")
    data class DetailPusatInformasi(val id : String) : Mentor("pusat-informasi/$id")
  }

  sealed class Mentor(route : String) : Screen(route) {
    object PenilaianPeserta : Mentor("penilaian-peserta")
    data class DetailPenilaianPeserta(val id : String) : Mentor("penilaian-peserta/$id")
    object FeedbackPeserta : Mentor("feedback-peserta")

    object Pitchdeck : Mentor("pitchdeck")
    data class DetailPitchdeck(val id : String) : Mentor("pitchdeck/$id")
    data class MoreDetailPitchdeck(val id : String) : Mentor("pitchdeck/$id/more")

    object ForumDiskusi : Mentor("forum-diskusi")
    data class DetailForumDiskusi(val id : String) : Mentor("forum-diskusi/$id")

    object DataPeserta : Mentor("data-peserta")
  }

  sealed class Kegiatan(route: String) : Screen(route){
    object JadwalMentoringBulan: Kegiatan ("jadwal-bulan")
//    data class JadwalMentoringBulan(val id : String): Kegiatan("jadwal_bulan/$id")
    data class JadwalMentoringMinggu(val id : String): Kegiatan("jadwal_minggu/$id")
    data class DetailJadwalMentoring(val id : String): Kegiatan("detail-jadwal/$id")
    data class UmpanBalikKegiatan(val id : String): Kegiatan("mini-training/$id")
  }

  sealed class Tugas(route: String) : Screen(route){
    object PitchDeck: Tugas ("pitch-deck")
    data class PitchDeckDetail(val id: String) : Tugas("detail-pitchdeck/$id")
  }

}
