package cl.ravenhill.makarena.model

import io.kotest.property.Arb
import io.kotest.property.arbitrary.codepoints
import io.kotest.property.arbitrary.string


fun nameGenerator() =
  Arb.string(minSize = 1, maxSize = 100, codepoints = Arb.Companion.codepoints())