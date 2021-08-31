package cl.ravenhill.makarena.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.codepoints
import io.kotest.property.arbitrary.string
import io.kotest.property.forAll

class NamedComponentTest : StringSpec({
  "Cards with the same parameters are equal" {
    forAll(nameGenerator(), attackGenerator()) { a, b ->
      Card(a, b) == Card(a, b)
    }
  }
})

fun nameGenerator() =
  Arb.string(minSize = 1, maxSize = 100, codepoints = Arb.Companion.codepoints())