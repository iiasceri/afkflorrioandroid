package md.ciocana.iiasceri.afkflorrioandroid

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform