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
    // form feedback mentor
    object FormFeedbackMentor : Peserta("form-mentor")
    data class FormFeedbackMentor2(val id : String) : Mentor("form-mentor2/$id")
    data class FormFeedbackMentor3(val id : String) : Mentor("form-mentor3/$id")
    data class FormFeedbackMentor4(val id : String) : Mentor("form-mentor4/$id")
  }

  sealed class Mentor(route : String) : Screen(route) {
    // Penilaian Peserta
    object PenilaianPeserta : Mentor("penilaian-peserta")
    data class DetailPenilaianPeserta(val id : String) : Mentor("penilaian-peserta/$id")
    // Feedback Peserta
    object FeedbackPeserta : Mentor("feedback-peserta")
    // PitchDeck Mentor
    object Pitchdeck : Mentor("pitchdeck")
    data class DetailPitchdeck(val id : String) : Mentor("pitchdeck/$id")
    data class MoreDetailPitchdeck(val id : String) : Mentor("pitchdeck/$id/more")
    // Forum Diskusi
    object ForumDiskusi : Mentor("forum-diskusi")
    data class DetailForumDiskusi(val id : String) : Mentor("forum-diskusi/$id")
    // Data Peserta
    object DataPeserta : Mentor("data-peserta")

  }

  sealed class Kegiatan(route: String) : Screen(route){
    object JadwalMentoringBulan: Kegiatan ("jadwal-bulan")
//    data class JadwalMentoringBulan(val id : String): Kegiatan("jadwal_bulan/$id")
    data class JadwalMentoringMinggu(val id : String): Kegiatan("jadwal_minggu/$id")
    data class DetailJadwalMentoring(val id : String): Kegiatan("detail-jadwal/$id")
    object UmpanBalikKegiatan: Kegiatan("mini-training")
  }

  sealed class Tugas(route: String) : Screen(route){
    object PitchDeck: Tugas ("pitch-deck")
    data class PitchDeckExpanded(val id: String) : Tugas("expanded-pitchdeck/$id")
    data class PitchDeckDetail(val id: String) : Tugas("detail-pitchdeck/$id")

  }

  object ProfilPeserta : Screen("profil-peserta")
}
