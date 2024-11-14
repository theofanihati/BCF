package com.example.slicingbcf.data.local


data class WilayahJangkauan(
    val no: Int,
    val provinsi: String,
    val penerimaManfaat: Int,
    val rincianUrl: String
)

data class ProfilLembaga(
    val name: String,
    val email: String,
    val address: String,
    val type: String,
    val cluster: String,
    val focusIssue: String,
    val programReason: String,
    val programCoverage: String,
    val companyProfilePdf: String,
    val programProposalPdf: String,
    val backgroundImageUrl: String,
    val profileImageUrl: String,
    val wilayahJangkauan: List<WilayahJangkauan>
)

val profilLembaga = listOf(
    ProfilLembaga(
        name = "Bakrie Center Foundation",
        email = "bcf@gmail.com",
        address = "Wisma Bakrie 2nd Floor, Jalan H.R. Rasuna Said Kav B-1",
        type = "Gerakan",
        cluster = "Pendidikan",
        focusIssue = "Pendidikan Anak Prasejahtera",
        programReason = "Karena ingin mengembangkan komunitas",
        programCoverage = "Provinsi",
        companyProfilePdf = "https://example.com/Profil_BCF.pdf",
        programProposalPdf = "https://example.com/Proposal_Program.pdf",
        backgroundImageUrl = "https://s3-alpha-sig.figma.com/img/bdd8/8a6c/88c67a5b1a7f2e590c5891844cb4fc22?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Jzxhi8~g0MDK5hdpItTvCjbA0mbIxvZyXMKFYYcRF-TKL6srsvhCNvEnC07q0nkgmUB-hbcYCylBrETbw3F~-qJC08tosX1vYDVPjdhyNP6sRWlA3sUsHGTY1SWY5OJ5NGdzoxx7NGQ0GnN7sicplo1s7JDwBiqAmSE~2ztE4bfsLxEPhimC~iCMoYOJPLvXZPDrksagG3rPOqflHPv9e5Y1R3lTfzHto4VPcHAhb9AODiZn4y3c63Bx~M5LTPxL0T3AZ~RWOGLciobCptC8hgLEBls5HJnPzrb9acOLwotKTydSyySy01vNwudKH5R6s3wLYxYokDggQUZJJdtorg__",
        profileImageUrl = "https://via.placeholder.com/100",
        wilayahJangkauan = listOf(
            WilayahJangkauan(1, "DKI Jakarta", 5000, "https://example.com/rincian1.pdf"),
            WilayahJangkauan(2, "Jawa Barat", 2700, "https://example.com/rincian2.pdf")
        )
    )
)

