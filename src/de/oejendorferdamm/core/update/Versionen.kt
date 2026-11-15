package de.oejendorferdamm.core.update

/**
 * Gemeinsamer Versionsvergleich aller Damm-Apps. Robust für x.y.z(.w), „v“-Präfix und Zusätze wie „-beta“.
 * Passt sowohl zum alten Semver (1.2.0) als auch zum Datumsschema (26.11.14 bzw. 26.11.14.1).
 */
object Versionen {
    /** true, wenn [neu] höher ist als [alt]. */
    fun istNeuer(neu: String, alt: String): Boolean {
        val a = teile(neu)
        val b = teile(alt)
        for (i in 0 until maxOf(a.size, b.size)) {
            val x = a.getOrElse(i) { 0 }
            val y = b.getOrElse(i) { 0 }
            if (x != y) return x > y
        }
        return false
    }

    private fun teile(v: String): List<Int> =
        v.trim().removePrefix("v").split('.').map { it.substringBefore('-').trim().toIntOrNull() ?: 0 }
}
