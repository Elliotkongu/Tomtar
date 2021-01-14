fun hittaTomte(id: String, tomte: Tomte, resultLista: MutableList<String>) {
    if (tomte.id == id) {
        if (tomte.children != null) {
            läggTillTomte(tomte, resultLista)
        } else {
            println("$id har inga underordnade")
        }
    } else {
        if (tomte.children != null) {
            for (child in tomte.children) {
                hittaTomte(id, child, resultLista)
            }
        }
    }
}

fun läggTillTomte(tomte: Tomte, resultLista: MutableList<String>) {
    if (tomte.children != null) {
        for (child in tomte.children!!) {
            resultLista.add(child.id)
            läggTillTomte(child, resultLista)
        }
    }
}

fun skrivUtUnderordnade(id: String) {
    val dammråttan = Tomte("Dammråttan", null)
    val skumtomten = Tomte("Skumtomten", listOf(dammråttan))
    val trötter = Tomte("Trötter", listOf(skumtomten))
    val tröger = Tomte("Tröger", null)
    val blyger = Tomte("Blyger", null)
    val glader = Tomte("Glader", listOf(tröger, trötter, blyger))
    val bladlusen = Tomte("Bladlusen", null)
    val myran = Tomte("Myran", listOf(bladlusen))
    val gråsuggan = Tomte("Gråsuggan", null)
    val räven = Tomte("Räven", listOf(myran, gråsuggan))
    val haren = Tomte("Haren", null)
    val nyckelpigan = Tomte("Nyckelpigan", null)
    val rådjuret = Tomte("Rådjuret", null)
    val butter = Tomte("Butter", listOf(rådjuret, nyckelpigan, haren, räven))
    val tomten = Tomte("Tomten", listOf(glader, butter))
    val resultLista: MutableList<String> = ArrayList()
    hittaTomte(id, tomten, resultLista)
    if (resultLista.isNotEmpty()){
        println("$id har underordnade $resultLista")
    }
}

fun main(args: Array<String>) {
    skrivUtUnderordnade("Dammråttan")
    skrivUtUnderordnade("Räven")
}